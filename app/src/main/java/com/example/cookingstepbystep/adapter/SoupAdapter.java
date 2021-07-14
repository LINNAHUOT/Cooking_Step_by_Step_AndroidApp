package com.example.cookingstepbystep.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cookingstepbystep.R;
import com.example.cookingstepbystep.SoupActivity;
import com.example.cookingstepbystep.model.Soup;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;

public class SoupAdapter extends RecyclerView.Adapter <SoupViewHolder> implements Filterable {
    Context context;
    ArrayList<Soup> list;
    ArrayList<Soup> backup; //asd

    public SoupAdapter(Context context, ArrayList<Soup> list) {
        this.context = context;
        this.list = list;
        this.backup = list; //asd
    }



    @NonNull
    @Override
    public SoupViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflate a layout to view object
        //LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        //View itemView = layoutInflater.inflate(R.layout.view_holder_soup,parent,false);
            View itemView = LayoutInflater.from(context).inflate(R.layout.view_holder_soup, parent,false);
        //create view holder
        return new SoupViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull SoupViewHolder holder, int position) {
        Soup soup = list.get(position);
        Picasso.with(context).load(soup.getThumbnailUrl()).into(holder.imgThumbnail);
        holder.txtSoupName.setText(soup.getName());

        /// onclick item listener
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse(soup.getVideoUrl());
                Intent intent = new Intent(Intent.ACTION_VIEW,uri);
                context.startActivity(intent);
            }
        });
        /// finish


    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    //Filter
    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                ArrayList<Soup> filter = new ArrayList<>();
                ArrayList<Soup> tmpItems = new ArrayList<>(backup);
                if (charSequence.toString().isEmpty()) {
                    filter.addAll(tmpItems);
                } else {
                    for (Soup item : tmpItems) {
                        if (item.getName().toLowerCase().contains(charSequence.toString().toString())) {
                            filter.add(item);
                        }
                    }
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = filter;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                list = (ArrayList<Soup>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }
    ///asd
}




