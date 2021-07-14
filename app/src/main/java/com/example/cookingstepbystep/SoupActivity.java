package com.example.cookingstepbystep;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cookingstepbystep.adapter.SoupAdapter;
import com.example.cookingstepbystep.model.Soup;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.TreeMap;

public class SoupActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    SoupAdapter soupAdapter;
    ArrayList<Soup> list;
    EditText editText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_btnbtnsoup);

        //Referent to RecyclerView
        RecyclerView recyclerView = findViewById(R.id.SoupRecycler);

        //Creat and assign layout manager
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        //create and assign adapter
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        editText = this.findViewById(R.id.search_toolbar);
        list = new ArrayList<>();
        soupAdapter = new SoupAdapter(this, list);
        recyclerView.setAdapter(soupAdapter);
        ///Database referent
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("soup");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot childDataSnapshot1 : dataSnapshot.getChildren()){
                    int id = Integer.valueOf(String.valueOf(childDataSnapshot1.child("id").getValue()));
                    String name = String.valueOf(childDataSnapshot1.child("name").getValue());
                    String Ingredients = String.valueOf(childDataSnapshot1.child("Ingredients").getValue());
                    String VideoUrl = String.valueOf(childDataSnapshot1.child("VideoUrl").getValue());
                    String thumbnailUrl = String.valueOf(childDataSnapshot1.child("thumbnailUrl").getValue());
                    String vitamin = String.valueOf(childDataSnapshot1.child("vitamin").getValue());
                    list.add(new Soup(id,name,Ingredients,vitamin,VideoUrl,thumbnailUrl));
                }
                soupAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        //asd

        ///asd
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                soupAdapter.getFilter().filter(s.toString().toLowerCase());
            }
        });
        ///asd

    }

}



        /*Soup[] soups = new Soup[]{

                new Soup(1, "Soup1", "Salt", "dffg", "html://bshdhy", "html://hfstuyavf"),
                new Soup(2, "Soup2", "Salt", "dffg", "html://bshdhy", "html://hfstuyavf"),
                new Soup(3, "Soup3", "Salt", "dffg", "html://bshdhy", "html://hfstuyavf")
        };
        SoupAdapter adapter = new SoupAdapter(soups);
        recyclerView.setAdapter(adapter);

    }*/



