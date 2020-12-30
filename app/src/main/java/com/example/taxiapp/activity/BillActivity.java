package com.example.taxiapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.taxiapp.R;

public class BillActivity extends AppCompatActivity {

    LinearLayout waiting;
    LinearLayout waitinginfo;
    ImageView icon_paid;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill);

        waiting = findViewById(R.id.waiting);
        waitinginfo = findViewById(R.id.waitinginfo);
        icon_paid = findViewById(R.id.icon_paid);

        findViewById(R.id.skip).setOnClickListener((v) -> {
            startActivity(new Intent(BillActivity.this, HomeActivity.class));
            finishAffinity();
        });
        findViewById(R.id.finding).setOnClickListener((v) -> {
            waitinginfo.setVisibility(View.VISIBLE);
            waiting.setVisibility(View.GONE);
            icon_paid.setVisibility(View.VISIBLE);

        });


    }
}