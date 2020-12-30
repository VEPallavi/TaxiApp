package com.example.taxiapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.taxiapp.R;

public class RouteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_route);

        findViewById(R.id.ll_details).setOnClickListener((v) -> {
            startActivity(new Intent(RouteActivity.this, BillActivity.class));

        });
    }
}