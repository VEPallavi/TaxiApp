package com.example.taxiapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.taxiapp.R;

public class LoginActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        findViewById(R.id.cv_login).setOnClickListener((v) -> {
            startActivity(new Intent(LoginActivity.this, EnterOtpActivity.class));
            finish();

        });


    }
}