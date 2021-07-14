package com.example.cookingstepbystep.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cookingstepbystep.R;

public class SoupViewHolder extends RecyclerView.ViewHolder {

     ImageView imgThumbnail;
     TextView txtSoupName;


    public SoupViewHolder(@NonNull View itemView) {
        super(itemView);

        imgThumbnail = itemView.findViewById(R.id.imgThumbnail);
        txtSoupName = itemView.findViewById(R.id.txtSoupName);
    }
}
