package com.example.cardviewexample;

import android.arch.lifecycle.LiveData;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import java.util.List;

public class StoreAdapter extends RecyclerView.Adapter<StoreViewHolder>{


    private List<Store> stores;
    Context context;

    public StoreAdapter(List<Store> stores,Context context){
        this.stores=stores;
        this.context=context;


    }



    @Override
    public StoreViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflate the layout file
        View groceryProductView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout, parent, false);
        StoreViewHolder gvh = new StoreViewHolder(groceryProductView);
        return gvh;
    }


    @Override
    public void onBindViewHolder(StoreViewHolder holder, final int position) {

        holder.phoneNumber.setText(stores.get(position).getPhoneNumber()+"");
        holder.description.setText(stores.get(position).getDescription());
        holder.address.setText(stores.get(position).getAddress());
        holder.hours.setText(stores.get(position).getHours());
        holder.img.setImageResource(stores.get(position).getImagePath());


    }

    @Override
    public int getItemCount() {
        return stores.size();
    }
}
