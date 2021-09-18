package com.example.tft_android;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.fragment.app.FragmentManager;

import com.example.tft_android.Class.Person;
import com.example.tft_android.FragmentRegister.RegisterOneFragment;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import com.google.firebase.auth.AuthResult;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class RegisterActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        RegisterOneFragment registerOneFragment = new RegisterOneFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().add(R.id.RegisterFrameLayout, registerOneFragment).commit();

        mAuth = FirebaseAuth.getInstance();

    }


    public void ButtonRegisterSignUp(final String email, String password, final String name, final String age, final String weight, final String height, final String sex, final String time, final String mattress,final String stairs,final String bottles,final String pullupbar){

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Toast.makeText(RegisterActivity.this, "Register successful",
                                    Toast.LENGTH_SHORT).show();
                            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                            String uid = user.getUid();

                            // Write a message to the database

                            FirebaseDatabase database = FirebaseDatabase.getInstance(); // מביא את החיבור לfirebase
                            DatabaseReference myRef = database.getReference("Person").child(uid);

                            Person p = new Person(email,name,age,weight,height,sex, time,mattress,stairs,bottles,pullupbar);
                            myRef.setValue(p);

                            startActivity(new Intent(getApplicationContext(),LoginActivity.class));

                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(RegisterActivity.this, "Register failed",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

}


