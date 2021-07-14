package com.example.cookingstepbystep;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cookingstepbystep.adapter.FriedAdapter;
import com.example.cookingstepbystep.adapter.SoupAdapter;
import com.example.cookingstepbystep.model.Fried;
import com.example.cookingstepbystep.model.Soup;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class FriedActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    FriedAdapter friedAdapter;
    ArrayList<Fried> list;
    EditText editText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_btnbtnfried);

        RecyclerView recyclerView = findViewById(R.id.FriedRecycler);
        //Creat and assign layout manager
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        //create and assign adapter
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        editText = this.findViewById(R.id.search_toolbar);
        list = new ArrayList<>();
        friedAdapter = new FriedAdapter(this, list);
        recyclerView.setAdapter(friedAdapter);

        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("fried");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot childDataSnapshot1 : snapshot.getChildren()) {
                    int id = Integer.valueOf(String.valueOf(childDataSnapshot1.child("id").getValue()));
                    String name = String.valueOf(childDataSnapshot1.child("name").getValue());
                    String Ingredients = String.valueOf(childDataSnapshot1.child("Ingredients").getValue());
                    String VideoUrl = String.valueOf(childDataSnapshot1.child("VideoUrl").getValue());
                    String thumbnailUrl = String.valueOf(childDataSnapshot1.child("thumbnailUrl").getValue());
                    String vitamin = String.valueOf(childDataSnapshot1.child("vitamin").getValue());
                    list.add(new Fried(id, name, Ingredients, vitamin, VideoUrl, thumbnailUrl));
                }
                friedAdapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                friedAdapter.getFilter().filter(s.toString().toLowerCase());
            }
        });
    }
}





