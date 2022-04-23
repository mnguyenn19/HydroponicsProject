package com.example.hponx;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Schedule extends AppCompatActivity {

    Button schedLight, schedMedium, schedHeavy, schedBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);

        schedLight = findViewById(R.id.LevelALight);
        schedMedium = findViewById(R.id.LevelBMedium);
        schedHeavy = findViewById(R.id.LevelCHeavy);
        schedBack = findViewById(R.id.LevelBack);

        schedBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}