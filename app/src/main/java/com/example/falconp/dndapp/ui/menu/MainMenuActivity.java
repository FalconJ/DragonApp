package com.example.falconp.dndapp.ui.menu;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.falconp.dndapp.MainActivity;
import com.example.falconp.dndapp.R;
import com.example.falconp.dndapp.data.network.NakamaSessionManager;
import com.example.falconp.dndapp.databinding.ActivityLoginBinding;
import com.example.falconp.dndapp.databinding.ActivityMainMenuBinding;
import com.example.falconp.dndapp.ui.character.NewCharacterActivity;
import com.example.falconp.dndapp.ui.login.LogInActivity;
import com.example.falconp.dndapp.ui.room.RoomActivity;
import com.google.firebase.auth.FirebaseAuth;

public class MainMenuActivity extends AppCompatActivity {

    private static final String TAG = "LogIn";
    private ActivityMainMenuBinding mMainMenuBinding;
    private NakamaSessionManager mSessionManager;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mMainMenuBinding = DataBindingUtil.setContentView(this, R.layout.activity_main_menu);

        // Initialize sessionManager
        mSessionManager = new NakamaSessionManager();
        mAuth = FirebaseAuth.getInstance();
        onClickListeners();
    }

    private void signOut(){
        mSessionManager.logOut();
        mAuth.signOut();

        Intent logInIntent = new Intent(getApplicationContext(), LogInActivity.class);
        logInIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        logInIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(logInIntent);
    }

    private void listCharacters(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private void room(){
        Intent intent = new Intent(this, RoomActivity.class);
        startActivity(intent);
    }

    private void onClickListeners(){
        mMainMenuBinding.roomsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                room();
            }
        });

        mMainMenuBinding.characterListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listCharacters();
            }
        });

        mMainMenuBinding.logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signOut();
            }
        });
    }
}
