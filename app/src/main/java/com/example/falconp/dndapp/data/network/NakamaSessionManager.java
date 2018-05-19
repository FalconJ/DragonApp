package com.example.falconp.dndapp.data.network;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import com.heroiclabs.nakama.*;
import com.heroiclabs.nakama.Error;
import com.heroiclabs.nakama.Error.ErrorCode;
import com.stumbleupon.async.*;

public class NakamaSessionManager {
    private final Client client;
    private final Callback<Error, Error> errCallback;
    private Session session;

    public NakamaSessionManager(){
        client = DefaultClient.builder("5LwHhurhMM")
                .host("104.196.168.44")
                .port(7350)
                .ssl(false)
                .build();

        errCallback = new Callback<Error, Error>() {
            @Override
            public Error call(Error err) throws Exception {
                System.err.format("Error('%s', '%s')", err.getCode(), err.getMessage());
                return  err;
            }
        };
    }

    /** Get the Client reference to send/receive messages from the server. */
    public Client getClient(){
        return client;
    }


    public void logOut(){
        client.logout()
                .addErrback(new Callback<Error, Error>() {
                    @Override
                    public Error call (Error error) throws Exception{
                        if(error.getCode() == ErrorCode.USER_NOT_FOUND){
                            // Login Failed this is a new user
                            System.err.format("Error('%s', '%s')", error.getCode(), error.getMessage());
                        }
                        throw error;
                    }
                });
    }

    /**
     * Login and connect a user using an email and password.
     * @param activity The Activity calling this method.
     * @param email The email to login with.
     * @param password The password to login with
     */
    public void logIn(final Activity activity, String email, String password){
        final AuthenticateMessage msg = AuthenticateMessage.Builder.email(email, password);
        client.login(msg)
                .addCallbackDeferring(new Callback<Deferred<Session>, Session>() {
                    @Override
                    public Deferred<Session> call(Session session) throws Exception {
                        // Log In was successful
                        // Store session for later use
                        SharedPreferences pref = activity.getPreferences(Context.MODE_PRIVATE);
                        pref.edit()
                                .putString("nk.session", session.getToken())
                                .apply();

                        return client.connect(session);
                    }
                })
                .addErrback(new Callback<Error, Error>() {
                    @Override
                    public Error call (Error error) throws Exception{
                        if(error.getCode() == ErrorCode.USER_NOT_FOUND){
                            // Login Failed this is a new user
                            System.err.format("Error('%s', '%s')", error.getCode(), error.getMessage());
                        }
                        throw error;
                    }
                })
                .addCallback(new Callback<Session, Session>() {
                    @Override
                    public Session call(Session session) throws Exception{
                        System.out.println("Connected");
                        return session;
                    }
                })
                .addErrback(errCallback);
    }

    public void register(final Activity activity, String email, String password){
        final AuthenticateMessage msg = AuthenticateMessage.Builder.email(email, password);
        client.register(msg)
                .addErrback(new Callback<Error, Error>() {
                    @Override
                    public Error call(Error error) throws Exception {
                        System.err.format("Error('%s', '%s')", error.getCode(), error.getMessage());
                        return error;
                    }
                })
                .addCallbackDeferring(new Callback<Deferred<Session>, Session>() {
                    @Override
                    public Deferred<Session> call(Session session) throws Exception {
                        // Registration has succeeded, try connecting again.
                        // Store the session for later use.
                        SharedPreferences pref = activity.getPreferences(Context.MODE_PRIVATE);
                        pref.edit().putString("nk.session", session.getToken()).apply();

                        return client.connect(session);
                    }
                })
                .addCallback(new Callback<Session, Session>() {
                    @Override
                    public Session call(Session session) throws Exception {
                        // We're connected to the server!
                        System.out.println("Connected!");
                        return session;
                    }
                })
                .addErrback(errCallback);
    }

    /**
     * Attempt to restore a Session from SharedPreferences and connect.
     * @param activity The Activity calling this method.
     */
    public void restoreSessionAndConnect(Activity activity) {
        SharedPreferences pref = activity.getPreferences(Context.MODE_PRIVATE);
        // Lets check if we can restore a cached session.
        String sessionString = pref.getString("nk.session", null);
        if (sessionString == null || sessionString.isEmpty()) {
            return; // We have no session to restore.
        }

        Session session = DefaultSession.restore(sessionString);
        if (session.isExpired(System.currentTimeMillis())) {
            return; // We can't restore an expired session.
        }

        final NakamaSessionManager self = this;
        client.connect(session)
                .addCallback(new Callback<Session, Session>() {
                    @Override
                    public Session call(Session session) throws Exception {
                        System.out.format("Session connected: '%s'.", session.getToken());
                        self.session = session;
                        return session;
                    }
                });
    }
}
