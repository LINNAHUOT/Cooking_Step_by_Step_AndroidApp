package com.example.cookingstepbystep.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cookingstepbystep.R;

public class FriedViewHolder extends RecyclerView.ViewHolder {

    ImageView imgThumbnail_Fried;
    TextView txtFriedName;

    public FriedViewHolder(@NonNull View itemView) {
        super(itemView);

        imgThumbnail_Fried = itemView.findViewById(R.id.imgThumbnailFried);
        txtFriedName = itemView.findViewById(R.id.txtFriedName);

    }
}
