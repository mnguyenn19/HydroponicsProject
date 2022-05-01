package com.example.hponx;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class homescreen extends AppCompatActivity {

    LinearLayout monitoring;
    LinearLayout scheduling;
    LinearLayout LWman;
    LinearLayout plantInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homescreen);

        monitoring = findViewById(R.id.layoutFour);
        scheduling = findViewById(R.id.layoutThree);
        LWman = findViewById(R.id.layoutTwo);
        plantInfo = findViewById(R.id.layoutOne);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        monitoring.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(homescreen.this, NPKRecycleView.class);
                startActivity(intent);
            }
        });

        scheduling.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(homescreen.this, Schedule.class);
                startActivity(intent);
            }
        });

        LWman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(homescreen.this, lightandwater.class);
                startActivity(intent);
            }
        });

        plantInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(homescreen.this, plant.class);
                startActivity(intent);
            }
        });
    }
}