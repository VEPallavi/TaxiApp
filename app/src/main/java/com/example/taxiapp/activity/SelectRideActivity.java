package com.example.taxiapp.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.example.taxiapp.R;
import com.example.taxiapp.adapter.TaxiAdapter;
import com.example.taxiapp.models.TaxiModel;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

import java.util.ArrayList;

public class SelectRideActivity extends AppCompatActivity {
    BottomSheetBehavior sheetBehavior;
    LinearLayout layoutBottomSheet;
    RecyclerView rcv;
    TaxiAdapter adapter;
    ArrayList<TaxiModel> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_ride);
        layoutBottomSheet = findViewById(R.id.bottom_sheet2);
        sheetBehavior = BottomSheetBehavior.from(layoutBottomSheet);
        rcv = findViewById(R.id.rv_cars);

        layoutBottomSheet.findViewById(R.id.colapse).setOnClickListener((v) -> {

            toogle();
        });
        layoutBottomSheet.findViewById(R.id.confirm2).setOnClickListener((v) -> {

            startSearchingRide();
        });


        rcv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true));

        StartSnapHelper snapHelper = new StartSnapHelper();
        snapHelper.attachToRecyclerView(rcv);
        addDataintoList();
        setListener();

    }


    void addDataintoList() {
        list = new ArrayList<>();
        adapter = new TaxiAdapter(this, list);


        TaxiModel model;

        model = new TaxiModel();
        model.setImg(R.drawable.car_1);
        model.setPeople(2);
        list.add(model);

        model = new TaxiModel();
        model.setImg(R.drawable.car_2);
        model.setPeople(4);
        list.add(model);

        model = new TaxiModel();
        model.setImg(R.drawable.car_3);
        model.setPeople(1);
        list.add(model);


        model = new TaxiModel();
        model.setImg(R.drawable.car_4);
        model.setPeople(3);
        list.add(model);


        rcv.setAdapter(adapter);

    }

    void setListener() {
        findViewById(R.id.selct_ride).setOnClickListener((v) -> {

            toogle();
        });

        findViewById(R.id.confirm1).setOnClickListener((v) -> {

            startSearchingRide();
        });
    }

    void toogle() {
        if (sheetBehavior.getState() != BottomSheetBehavior.STATE_EXPANDED) {
            sheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
        } else {
            sheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
        }
    }

    void startSearchingRide() {
        startActivity(new Intent(this, FindingRideActivity.class));
    }
}