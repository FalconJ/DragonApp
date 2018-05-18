package com.example.falconp.dndapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.heroiclabs.nakama.AuthenticateMessage;
import com.heroiclabs.nakama.Client;
import com.heroiclabs.nakama.DefaultClient;
import com.heroiclabs.nakama.Error;
import com.heroiclabs.nakama.Session;
import com.stumbleupon.async.Callback;
import com.stumbleupon.async.Deferred;

import java.util.UUID;

public class MainActivity extends AppCompatActivity {
    Client client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    protected void onStart() {
        super.onStart();

        client = DefaultClient.builder("5LwHhurhMM")
                .host("104.196.168.44")
                .port(7350)
                .ssl(false)
                .build();

        register();
    }

    private void register(){
        String id = UUID.randomUUID().toString();
        final AuthenticateMessage message = AuthenticateMessage.Builder.device(id);
        Deferred<Session> deferred = client.login(message);
        deferred.addCallbackDeferring(new Callback<Deferred<Session>, Session>() {
            @Override
            public Deferred<Session> call(Session session) throws Exception {
                return client.connect(session);
            }
        }).addErrback(new Callback<Deferred<Session>, Error>() {
            @Override
            public Deferred<Session> call(Error err) throws Exception {
                if (err.getCode() == Error.ErrorCode.USER_NOT_FOUND) {
                    System.out.println("User not found, we'll register the user.");
                    return client.register(message);
                }
                throw err;
            }
        }).addCallbackDeferring(new Callback<Deferred<Session>, Session>() {
            @Override
            public Deferred<Session> call(Session session) throws Exception {
                return client.connect(session);
            }
        }).addCallback(new Callback<Session, Session>() {
            @Override
            public Session call(Session session) throws Exception {
                System.out.format("Session connected: '%s'", session.getToken());
                return session;
            }
        }).addErrback(new Callback<Error, Error>() {
            @Override
            public Error call(Error err) throws Exception {
                System.err.format("Error('%s', '%s')", err.getCode(), err.getMessage());
                return err;
            }
        });

    }
}
