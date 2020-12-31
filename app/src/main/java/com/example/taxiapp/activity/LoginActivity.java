package com.example.taxiapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.example.taxiapp.R;

public class LoginActivity extends AppCompatActivity {
    EditText mobile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mobile = findViewById(R.id.mobile);
        findViewById(R.id.cv_login).setOnClickListener((v) -> {
            if (mobile.getText().toString().trim().length() > 0) {
                if (mobile.getText().toString().trim().length() >= 10) {
                    startActivity(new Intent(LoginActivity.this, EnterOtpActivity.class));
                    finish();
                } else {
                    Toast.makeText(this, "Please enter 10 digit mobile number", Toast.LENGTH_SHORT).show();
                }

            } else {
                Toast.makeText(this, "Please enter mobile number", Toast.LENGTH_SHORT).show();
            }


        });


    }
}