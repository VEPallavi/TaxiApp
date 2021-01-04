package com.example.taxiapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
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
import com.google.android.material.navigation.NavigationView;

public class HomeActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    BottomSheetBehavior sheetBehavior;
    LinearLayout layoutBottomSheet;
    TextViewBold tv_enterLocation;
    NavigationView navigationView;
    View headerView;
    LinearLayout ll_trip, ll_payment, ll_setting;
    ImageView menu_icon;
    DrawerLayout navDrawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        navDrawer = findViewById(R.id.drawer_layout);
        layoutBottomSheet = findViewById(R.id.bottom_sheet);
        tv_enterLocation = findViewById(R.id.tv_enterLocation);
        navigationView = findViewById(R.id.nav_view);
        headerView = navigationView.getHeaderView(0);
        ll_trip = headerView.findViewById(R.id.ll_trip);
        ll_payment = headerView.findViewById(R.id.ll_payment);
        ll_setting = headerView.findViewById(R.id.ll_setting);
        menu_icon = findViewById(R.id.menu_icon);

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

        navigationView.findViewById(R.id.ll_logout).setOnClickListener((v) -> {
            startActivity(new Intent(HomeActivity.this, LoginActivity.class));
            finishAffinity();
        });


        ll_trip.setOnClickListener((v) -> {

            Toast.makeText(this, "Work pending", Toast.LENGTH_SHORT).show();
           // startActivity(new Intent(HomeActivity.this, TripActivity.class));
        });

        ll_payment.setOnClickListener((v) -> {

            startActivity(new Intent(HomeActivity.this, PaymentActivity.class));
        });

        ll_setting.setOnClickListener((v) -> {

            startActivity(new Intent(HomeActivity.this, SettingActivity.class));
        });

        menu_icon.setOnClickListener((v) -> {
          
            if (!navDrawer.isDrawerOpen(GravityCompat.START))
                navDrawer.openDrawer(GravityCompat.START);
            else navDrawer.closeDrawer(GravityCompat.END);
        });

    }
}