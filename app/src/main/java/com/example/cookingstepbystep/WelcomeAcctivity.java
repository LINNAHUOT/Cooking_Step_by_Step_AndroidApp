package com.example.cookingstepbystep;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class WelcomeAcctivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.acctivity_welcome_page);
        //Delay 2s then move to HomeScreen
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(WelcomeAcctivity.this, CookingStepActivity.class);
                startActivity(intent);
                finish();

            }
        }, 1000);
    }
    public void OnGetStartedClick (View welcome_view){
        Intent intent = new Intent(this, CookingStepActivity.class);
        startActivity(intent);
        finish();


    }
}
