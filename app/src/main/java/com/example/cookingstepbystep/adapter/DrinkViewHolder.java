package com.example.cookingstepbystep.adapter;

import android.media.Image;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cookingstepbystep.R;

public class DrinkViewHolder extends RecyclerView.ViewHolder {

    public ImageView imgThumbnail_Drink;
    public TextView txtDrinkName;

    public DrinkViewHolder(@NonNull View itemView) {
        super(itemView);
        imgThumbnail_Drink = itemView.findViewById(R.id.imgThumbnailDrink);
        txtDrinkName = itemView.findViewById(R.id.txtDrinkName);


    }
}
