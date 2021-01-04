package com.example.taxiapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.taxiapp.R;

public class EnterOtpActivity extends AppCompatActivity {
    EditText otp1, otp2, otp3, otp4;
    TextView timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_otp);

        otp1 = findViewById(R.id.otp1);
        otp2 = findViewById(R.id.otp2);
        otp3 = findViewById(R.id.otp3);
        otp4 = findViewById(R.id.otp4);
        timer = findViewById(R.id.timer);
        findViewById(R.id.tv_go).setOnClickListener((v) -> {

            String otp = otp1.getText().toString().trim() + otp2.getText().toString().trim() + otp3.getText().toString().trim() + otp4.getText().toString().trim();
            if (otp.length() == 4) {
                startActivity(new Intent(EnterOtpActivity.this, HomeActivity.class));
            } else {
                Toast.makeText(this, "Please enter 4 digit otp", Toast.LENGTH_SHORT).show();
            }

        });

        findViewById(R.id.iv_back).setOnClickListener((v) -> {
            finish();
        });


        otp1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
                if (charSequence.length() > 0) {
                    otp2.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        otp2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
                if (charSequence.length() > 0) {
                    otp3.requestFocus();
                }
                if (count == 0) {
                    otp1.requestFocus(1);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        otp3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
                if (charSequence.length() > 0) {
                    otp4.requestFocus();
                }
                if (count == 0) {
                    otp2.requestFocus(1);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        otp4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
                if (count == 0) {
                    otp3.requestFocus(1);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        new CountDownTimer(60 * 1000, 1000) {

            public void onTick(long millisUntilFinished) {
                timer.setText(millisUntilFinished / 1000 + " Seconds");
            }

            public void onFinish() {
                timer.setText("0 Second");
            }

        }.start();

    }


}