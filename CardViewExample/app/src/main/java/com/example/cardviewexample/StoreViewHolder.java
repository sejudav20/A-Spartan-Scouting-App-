package com.example.cardviewexample;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

public class StoreViewHolder extends RecyclerView.ViewHolder{
ImageView img;
Switch open;
TextView description;
TextView hours;
TextView address;
TextView phoneNumber;


    public StoreViewHolder(View view) {

        super(view);
        img= view.findViewById(R.id.imageView2);
        open=view.findViewById(R.id.switch2);
        description=view.findViewById(R.id.Description);
        hours=view.findViewById(R.id.Hours);
        address=view.findViewById(R.id.Address);
        phoneNumber=view.findViewById(R.id.phone);


    }



        }
