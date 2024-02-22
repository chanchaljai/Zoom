package com.example.demo2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.Firebase;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginScreen extends AppCompatActivity {
    EditText mEmail, mPassword;
    Button mBtn;
    TextView mSign;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);
        mEmail = findViewById(R.id.le2);
        mPassword = findViewById(R.id.lp2);
        mBtn = findViewById(R.id.lb2);
        mSign = findViewById(R.id.ls2);
        mAuth = FirebaseAuth.getInstance();


        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = mEmail.getText().toString();
                String password = mPassword.getText().toString();
                if (!email.isEmpty() && !password.isEmpty()){
                    mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(LoginScreen.this, "Login Successfull", Toast.LENGTH_SHORT).show();
                                Intent i2 = new Intent(LoginScreen.this, HomeActivity.class);
                                startActivity(i2);
                            }
                        }
                    });
                }else {
                    Toast.makeText(LoginScreen.this, "Please fill empty", Toast.LENGTH_SHORT).show();
                }
            }
        });

        mSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 = new Intent(LoginScreen.this,SignupScreen.class);
                startActivity(i2);
            }
        });

    }
}