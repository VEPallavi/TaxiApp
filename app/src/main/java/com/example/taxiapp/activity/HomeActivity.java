package com.example.taxiapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;

import com.example.taxiapp.R;
import com.example.taxiapp.font.TextViewBold;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

public class HomeActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    BottomSheetBehavior sheetBehavior;
    LinearLayout layoutBottomSheet;
    TextViewBold tv_enterLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        layoutBottomSheet = findViewById(R.id.bottom_sheet);
        tv_enterLocation = findViewById(R.id.tv_enterLocation);
        sheetBehavior = BottomSheetBehavior.from(layoutBottomSheet);

        listener();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }


    void listener() {
        sheetBehavior.addBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {

                switch (newState) {
                    case BottomSheetBehavior.STATE_HIDDEN:
                        break;
                    case BottomSheetBehavior.STATE_EXPANDED: {
                        tv_enterLocation.setText("Close Sheet");
                    }
                    break;
                    case BottomSheetBehavior.STATE_COLLAPSED: {
                        tv_enterLocation.setText("Expand Sheet");
                    }
                    break;
                    case BottomSheetBehavior.STATE_DRAGGING:
                        break;
                    case BottomSheetBehavior.STATE_SETTLING:
                        break;
                }
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {

            }

        });
        findViewById(R.id.ll_now).setOnClickListener((v) -> {
            if (sheetBehavior.getState() != BottomSheetBehavior.STATE_EXPANDED) {
                sheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                tv_enterLocation.setText("Close sheet");
            } else {
                sheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                tv_enterLocation.setText("Expand sheet");
            }

        });

        findViewById(R.id.tv_enterLocation).setOnClickListener((v) -> {

            startActivity(new Intent(HomeActivity.this, SelectLocationACtivity.class));
        });
    }
}