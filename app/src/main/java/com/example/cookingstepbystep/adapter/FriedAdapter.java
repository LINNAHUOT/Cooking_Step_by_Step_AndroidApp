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
import com.example.cookingstepbystep.model.Fried;
import com.example.cookingstepbystep.model.Soup;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class FriedAdapter extends RecyclerView.Adapter <FriedViewHolder> implements Filterable {

    Context context;
    ArrayList<Fried> list;
    ArrayList<Fried> backup;

    public FriedAdapter(Context context, ArrayList<Fried> list) {
        this.context = context;
        this.list = list;
        this.backup = list;
    }



    @NonNull
    @Override
    public FriedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.view_holder_fried,parent,false);
        return  new FriedViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FriedViewHolder holder, int position) {
            Fried fried = list.get(position);
            Picasso.with(context).load(fried.getThumbnailUrl()).into(holder.imgThumbnail_Fried);
        holder.txtFriedName.setText(fried.getName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse(fried.getVideoUrl());
                Intent intent = new Intent(Intent.ACTION_VIEW,uri);
                context.startActivity(intent);
            }
        });

    }
    @Override
    public int getItemCount() {
        return list.size();
    }
    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                ArrayList<Fried> filter = new ArrayList<>();
                ArrayList<Fried> tmItems =  new ArrayList<>(backup);

                if (constraint.toString().isEmpty()) {
                   filter.addAll(tmItems);


                } else {
                            for (Fried item : tmItems){
                                if (item.getName().toLowerCase().contains(constraint.toString().toString()));{
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
                list=(ArrayList<Fried>) results.values;
                notifyDataSetChanged();

            }
        };
    }


}





