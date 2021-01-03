package com.example.taxiapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.taxiapp.R;

public class PaymentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        findViewById(R.id.iv_back).setOnClickListener((v)->{finish();});
    }
}