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

import com.example.cookingstepbystep.adapter.DrinkAdapter;
import com.example.cookingstepbystep.adapter.FriedAdapter;
import com.example.cookingstepbystep.adapter.SoupAdapter;
import com.example.cookingstepbystep.model.Drink;
import com.example.cookingstepbystep.model.Fried;
import com.example.cookingstepbystep.model.Soup;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class DrinkActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    DrinkAdapter drinkAdapter;
    ArrayList<Drink> list;
    EditText editText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_btndrink);

        recyclerView = findViewById(R.id.DrinkRecycler);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        editText = this.findViewById(R.id.search_toolbar) ;
        list = new ArrayList<>();
        drinkAdapter = new DrinkAdapter(this, list);
        recyclerView.setAdapter(drinkAdapter);

        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("drink");
        databaseReference.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot childDataSnapshot: snapshot.getChildren()){
                    int id = Integer.valueOf(String.valueOf(childDataSnapshot.child("id").getValue()));
                    String name = String.valueOf(childDataSnapshot.child("name").getValue());
                    String Ingredients = String.valueOf(childDataSnapshot.child("Ingredients").getValue());
                    String VideoUrl = String.valueOf(childDataSnapshot.child("VideoUrl").getValue());
                    String thumbnailUrl = String.valueOf(childDataSnapshot.child("thumbnailUrl").getValue());
                    String vitamin = String.valueOf(childDataSnapshot.child("vitamin").getValue());
                    list.add(new Drink(id,name,Ingredients,vitamin,VideoUrl,thumbnailUrl));
                }
                drinkAdapter.notifyDataSetChanged();
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
                drinkAdapter.getFilter().filter(s.toString().toLowerCase());
            }
        });
        ///asd

    }




    }
