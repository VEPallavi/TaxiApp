package com.example.taxiapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.taxiapp.R;
import com.example.taxiapp.models.TaxiModel;

import java.util.ArrayList;

public class TaxiAdapter extends RecyclerView.Adapter<TaxiAdapter.ViewHolder> {


    Context context;
    private ArrayList<TaxiModel> itemList;

    private String currencySymbols;


    public TaxiAdapter(Context context, ArrayList<TaxiModel> itemList) {
        this.context = context;
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public TaxiAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new TaxiAdapter.ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_taxi, parent, false));
    }

    @Override
    public void onBindViewHolder(TaxiAdapter.ViewHolder holder, final int position) {
        holder.image.setImageResource(itemList.get(position).getImg());
        holder.people.setText("" + itemList.get(position).getPeople()+" People");


    }


    @Override
    public int getItemCount() {
        return itemList.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {

        TextView people;
        ImageView image;

        ViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            people = itemView.findViewById(R.id.people);


        }
    }

}