package com.example.taxiapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.taxiapp.R;

public class FindingRideActivity extends AppCompatActivity {


    private LinearLayout finding_info;
    private LinearLayout ll_driver_info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finding_ride);

        finding_info = findViewById(R.id.finding_info);
        ll_driver_info = findViewById(R.id.ll_driver_info);

        findViewById(R.id.finding).setOnClickListener((v) -> {
            finding_info.setVisibility(View.GONE);
            ll_driver_info.setVisibility(View.VISIBLE);

        });

        findViewById(R.id.cancel).setOnClickListener((v) -> {
            finish();

        });

        findViewById(R.id.call).setOnClickListener((v) -> {
            Toast.makeText(this, "CAlling..", Toast.LENGTH_SHORT).show();

        });

        ll_driver_info.setOnClickListener((v) -> {

            startActivity(new Intent(FindingRideActivity.this, RouteActivity.class));
        });


    }
}