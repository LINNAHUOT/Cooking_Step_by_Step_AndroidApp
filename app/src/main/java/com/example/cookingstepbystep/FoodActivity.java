package com.example.cookingstepbystep;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

import com.example.cookingstepbystep.model.Fried;

public class FoodActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_btnfood);
    }
    public void onFriedClick(View view){

        Intent intent = new Intent(this, FriedActivity.class);
        startActivity(intent);

    }
    public void onSoupClick(View view){
        Intent intent = new Intent(this, SoupActivity.class);
        startActivity(intent);

    }

}
