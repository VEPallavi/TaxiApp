package com.example.taxiapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.taxiapp.R;

public class SelectLocationACtivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_location_a_ctivity);
        setListener();
    }

    void setListener() {
        findViewById(R.id.tv_go).setOnClickListener((v) -> {
            startActivity(new Intent(SelectLocationACtivity.this, SelectRideActivity.class));
        });
    }
}