package com.example.cookingstepbystep;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.cookingstepbystep.fragment.AboutUsFragment;
import com.example.cookingstepbystep.fragment.FavouriteFragment;
import com.example.cookingstepbystep.fragment.HomeFragment;
import com.example.cookingstepbystep.fragment.SearchFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class CookingStepActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.cooking_step_by_step);
        //reference
        BottomNavigationView bottomNavigationView = findViewById(R.id.btm_navigation);
        //on click on each icon
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                handleBottomNavigation(item);
                return true;
            }
        });
        //as defult
        showFragment(new HomeFragment());
    }
    private void handleBottomNavigation(MenuItem item){
        if(item.getItemId()==R.id.mnuAbout) {
            showFragment(new AboutUsFragment());
        }else  if(item.getItemId()==R.id.mnFavourite) {
            showFragment(new FavouriteFragment());
        }else  if(item.getItemId()==R.id.mnuHome) {
            showFragment(new HomeFragment());
        }else {
            showFragment(new SearchFragment());

        }

    }
    private void showFragment (Fragment fragment){
       FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.lyt_FragmentContainer, fragment);
        fragmentTransaction.commit();


    }


    public void onFoodClick(View view){

        Intent intent = new Intent(this, FoodActivity.class);
        startActivity(intent);

    }
    public void onDrinkClick(View view){
        Intent intent = new Intent(this, DrinkActivity.class);
        startActivity(intent);

    }

}
















