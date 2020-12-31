package com.example.taxiapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.example.taxiapp.R;

public class SelectLocationACtivity extends AppCompatActivity {
    EditText et_pick_location, et_drop_location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_location_a_ctivity);

        et_pick_location = findViewById(R.id.et_pick_location);
        et_drop_location = findViewById(R.id.et_drop_location);


        setListener();
    }

    void setListener() {
        findViewById(R.id.tv_go).setOnClickListener((v) -> {


            String dropLocation = et_drop_location.getText().toString().trim();
            String pickLocation = et_pick_location.getText().toString().trim();
            if (pickLocation.length() > 0) {
                if (dropLocation.length() > 0) {
                    startActivity(new Intent(SelectLocationACtivity.this, SelectRideActivity.class));
                } else {
                    Toast.makeText(this, "Please enter your destination address", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, "Please enter your Source address", Toast.LENGTH_SHORT).show();
            }

        });

        findViewById(R.id.iv_back).setOnClickListener((v) -> {
            finish();
        });
    }
}