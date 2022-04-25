package com.example.hponx;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Schedule extends AppCompatActivity {

    Button schedLight, schedMedium, schedHeavy;
    private final DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);

        schedLight = findViewById(R.id.LevelALight);
        schedMedium = findViewById(R.id.LevelBMedium);
        schedHeavy = findViewById(R.id.LevelCHeavy);

        schedLight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseReference.child("scheduleData").child("Intensity").setValue("low");
            }
        });

        schedMedium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseReference.child("scheduleData").child("Intensity").setValue("medium");
            }
        });

        schedHeavy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseReference.child("scheduleData").child("Intensity").setValue("high");
            }
        });
    }
}