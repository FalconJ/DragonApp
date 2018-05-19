package com.example.falconp.dndapp.ui.login;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.falconp.dndapp.R;
import com.example.falconp.dndapp.data.network.NakamaSessionManager;
import com.example.falconp.dndapp.databinding.ActivityLoginBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.heroiclabs.nakama.Match;

public class LogInActivity extends AppCompatActivity {

    private static final String TAG = "LogIn";
    private ActivityLoginBinding mLogInBinding;
    private NakamaSessionManager mSessionManager;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mLogInBinding = DataBindingUtil.setContentView(this, R.layout.activity_login);

        onClickListeners();

        // Initialize sessionManager
        mSessionManager = new NakamaSessionManager();
        mAuth = FirebaseAuth.getInstance();

    }


    @Override
    protected void onStart() {
        super.onStart();

        //Check if user is signed in (non null) and update UI accordingly
        mSessionManager.restoreSessionAndConnect(this);
        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);
    }

    private void createAccount(String email, String password) {
        Log.d(TAG, "created account: " + email);
        if (!validateForm()) {
            return;
        }

        mSessionManager.register(this, email, password);
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(LogInActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }
                    }
                });
    }

    private void signIn(String email, String password) {
        Log.d(TAG, "signIn: " + email);
        if (!validateForm()) {
            return;
        }

        mSessionManager.logIn(this, email, password);
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(LogInActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }

                        if (!task.isSuccessful()) {
                            mLogInBinding.status.setText(R.string.auth_failed);
                        }
                    }
                });
    }

    private void signOut() {
        mSessionManager.createMatch();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        mLogInBinding.status.setText(mSessionManager.getNewMatch().getId());
        //mSessionManager.logOut();
        //mAuth.signOut();
        System.out.println("Logged out");
        //updateUI(null);
    }

    private boolean validateForm() {
        boolean valid = true;

        String email = mLogInBinding.fieldEmail.getText().toString();
        if (TextUtils.isEmpty(email)) {
            mLogInBinding.fieldEmail.setError("Required.");
            valid = false;
        } else {
            mLogInBinding.fieldEmail.setError(null);
        }

        String password = mLogInBinding.fieldPassword.getText().toString();
        if (TextUtils.isEmpty(password) && password.length() >= 8) {
            mLogInBinding.fieldPassword.setError("Required, it must be over 8 characters long.");
            valid = false;
        } else {
            mLogInBinding.fieldPassword.setError(null);
        }

        return valid;
    }

    private void updateUI(FirebaseUser user) {
        if (user != null) {
            mLogInBinding.emailPasswordButtons.setVisibility(View.GONE);
            mLogInBinding.emailPasswordFields.setVisibility(View.GONE);
            mLogInBinding.signedInButtons.setVisibility(View.VISIBLE);
        } else {
            mLogInBinding.emailPasswordButtons.setVisibility(View.VISIBLE);
            mLogInBinding.emailPasswordFields.setVisibility(View.VISIBLE);
            mLogInBinding.signedInButtons.setVisibility(View.GONE);
        }
    }

    public void onClickListeners() {
        mLogInBinding.emailCreateAccountButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        createAccount(
                                mLogInBinding.fieldEmail.getText().toString(),
                                mLogInBinding.fieldPassword.getText().toString()
                        );
                    }
                }
        );

        mLogInBinding.emailSignInButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        signIn(
                                mLogInBinding.fieldEmail.getText().toString(),
                                mLogInBinding.fieldPassword.getText().toString()
                        );
                    }
                }
        );

        mLogInBinding.signOutButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        signOut();
                    }
                }
        );
    }
}