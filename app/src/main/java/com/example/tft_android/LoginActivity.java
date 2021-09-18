package com.example.tft_android;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    EditText lEmail, lPassword;
    Button LoginButton;
    private FirebaseAuth mAuth;
    ProgressBar progressBar;
    SharedPreferences sharedPreferences; /////

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();
        lEmail = findViewById(R.id.inputEmail);
        lPassword = findViewById(R.id.inputPassword);
        LoginButton = findViewById(R.id.buttonLogin);

        sharedPreferences = getPreferences(MODE_PRIVATE);//////
        if(sharedPreferences.getString("KeyEmail",null)!=null)
        {
            Intent intent = new Intent (this, TrainingActivity.class);
            startActivity(intent);
        }//////

    }

    public void LoginClick(View V) {
        String email = lEmail.getText().toString().trim();
        String password = lPassword.getText().toString().trim();

        //sharedPreferences
        sharedPreferences = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("KeyEmail", lEmail.getText().toString());
        editor.putString("KeyPassword", lPassword.getText().toString());
        editor.apply();///

        if(TextUtils.isEmpty(email)) {
            lEmail.setError("Email is Required");
            return;
        }
        if(TextUtils.isEmpty(password)){
            lPassword.setError("Password is Required");
            return;
        }
        if(password.length() < 6){
            lPassword.setError("Password must be longer than 6 characters");
            return;
        }

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task){
                        if (task.isSuccessful()) {
                            Toast.makeText(LoginActivity.this, "Login successful",
                                    Toast.LENGTH_SHORT).show();
                            FirebaseUser user = mAuth.getCurrentUser();
                            startActivity(new Intent(getApplicationContext(),TrainingActivity.class));
                            finish();

                        }
                        else {
                            Toast.makeText(LoginActivity.this, "Login failed",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    public void SignUpClick(View view) {

        Intent intent = new Intent(getApplicationContext(),RegisterActivity.class);
        startActivity(intent);
    }

}
