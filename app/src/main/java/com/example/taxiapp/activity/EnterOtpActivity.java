package com.example.taxiapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.taxiapp.R;

public class EnterOtpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_otp);
        findViewById(R.id.tv_go).setOnClickListener((v) -> {

            startActivity(new Intent(EnterOtpActivity.this, HomeActivity.class));
        });
    }
}