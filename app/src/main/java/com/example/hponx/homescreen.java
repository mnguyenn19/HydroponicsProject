package com.example.hponx;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class homescreen extends AppCompatActivity {

    LinearLayout monitoring;
    LinearLayout scheduling;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homescreen);

        monitoring = findViewById(R.id.layoutFour);
        scheduling = findViewById(R.id.layoutThree);

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
    }
}