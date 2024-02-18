package com.example.demo2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SignupScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_screen);

        EditText edtName, edtEmail,edtPassword;
        Button b1;
        TextView sign;

        edtName = findViewById(R.id.name);
        edtEmail = findViewById(R.id.email);
        edtPassword = findViewById(R.id.pass);
        b1 = findViewById(R.id.bs1);
        sign = findViewById(R.id.signin);

        

    }
}