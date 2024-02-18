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
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignupScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_screen);

        EditText edtName, edtEmail,edtPassword;
        Button bs1;
        TextView sign;
        FirebaseAuth mAuth;



        edtName = findViewById(R.id.name);
        edtEmail = findViewById(R.id.email);
        edtPassword = findViewById(R.id.pass);
        bs1 = findViewById(R.id.bs1);
        sign = findViewById(R.id.signin);
        mAuth = FirebaseAuth.getInstance();

        bs1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = edtName.getText().toString();
                String email = edtEmail.getText().toString();
                String pass = edtPassword.getText().toString();

                if(!name.isEmpty() && !email.isEmpty() && !pass.isEmpty()){
                    mAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(SignupScreen.this, "Account successfully created", Toast.LENGTH_SHORT).show();
                            }else {
                                Toast.makeText(SignupScreen.this, ""+task.getException(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }else {
                    Toast.makeText(SignupScreen.this, "Please fill empty field", Toast.LENGTH_SHORT).show();

                }
                Intent s1 = new Intent(SignupScreen.this,LoginScreen.class);
                startActivity(s1);
            }

        });
        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent s2 = new Intent(SignupScreen.this,LoginScreen.class);
                startActivity(s2);
            }
        });




    }
}