package com.example.taxiapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.taxiapp.R;

import in.mayanknagwanshi.countrypicker.CountrySelectActivity;
import in.mayanknagwanshi.countrypicker.bean.CountryData;

public class LoginActivity extends AppCompatActivity {
    EditText mobile;
    ImageView flag, verifiedImage;
    TextView countryCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mobile = findViewById(R.id.mobile);
        flag = findViewById(R.id.flag);
        countryCode = findViewById(R.id.countryCode);
        verifiedImage = findViewById(R.id.verifiedImage);

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

        findViewById(R.id.ll_country).setOnClickListener((v) -> {
            Intent intent = new Intent(this, CountrySelectActivity.class);
            startActivityForResult(intent, 1213);

        });

        mobile.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (s.length() == 10) {
                    verifiedImage.setVisibility(View.VISIBLE);
                } else {
                    verifiedImage.setVisibility(View.GONE);
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1213 && resultCode == Activity.RESULT_OK) {
            CountryData countryData = (CountryData) data.getSerializableExtra(CountrySelectActivity.RESULT_COUNTRY_DATA);
            countryCode.setText(countryData.getCountryISD());
            flag.setImageResource(countryData.getCountryFlag());

        }
    }

}