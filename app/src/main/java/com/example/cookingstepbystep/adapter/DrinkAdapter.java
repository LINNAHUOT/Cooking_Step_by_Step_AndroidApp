package com.example.cookingstepbystep.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cookingstepbystep.R;
import com.example.cookingstepbystep.model.Drink;
import com.example.cookingstepbystep.model.Fried;
import com.example.cookingstepbystep.model.Soup;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class DrinkAdapter extends RecyclerView.Adapter <DrinkViewHolder> implements Filterable {

    Context context;
    ArrayList<Drink> list;
    ArrayList<Drink> backup; //asd

    public DrinkAdapter(Context context, ArrayList<Drink> list) {
        this.context = context;
        this.list = list;
        this.backup = list;
    }




    @NonNull
    @Override
    public DrinkViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view2 = LayoutInflater.from(context).inflate(R.layout.view_holder_drink,parent,false);
        return new DrinkViewHolder(view2);

    }

    @Override
    public void onBindViewHolder(@NonNull DrinkViewHolder holder, int position) {

        Drink drink = list.get(position);
        Picasso.with(context).load(drink.getThumbnailUrl()).into(holder.imgThumbnail_Drink);
        holder.txtDrinkName.setText(drink.getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse(drink.getVideoUrl());
                Intent intent = new Intent(Intent.ACTION_VIEW,uri);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return  list.size();
    }
    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                ArrayList<Drink> filter = new ArrayList<>();
                ArrayList<Drink> tItems = new ArrayList<>(backup);
                if (constraint.toString().isEmpty()){
                    filter.addAll(tItems);
                } else {
                    for (Drink item : tItems) {
                        if (item.getName().toLowerCase().contains(constraint.toString().toString())) {
                            filter.add(item);
                        }
                    }
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = filter;
                return filterResults;
                }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                list = (ArrayList<Drink>) results.values;
                notifyDataSetChanged();
            }

        };
    }

}