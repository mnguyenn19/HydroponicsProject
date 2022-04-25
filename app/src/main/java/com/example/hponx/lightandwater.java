package com.example.hponx;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.tabs.TabLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class lightandwater extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    private final DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();

    Button L_ON, L_OFF, W_ON, W_OFF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lightandwater);

        tabLayout = findViewById(R.id.LWTab);
        viewPager = findViewById(R.id.LWvPager);

        tabLayout.addTab(tabLayout.newTab().setText("Light"));
        tabLayout.addTab(tabLayout.newTab().setText("Water"));

        /*
        L_ON = findViewById(R.id.LightOn);
        L_OFF = findViewById(R.id.LightOff);

        L_ON.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseReference.child("light").child("Power").setValue("on");
            }
        });

        L_OFF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseReference.child("light").child("Power").setValue("of");
            }
        });


        W_ON = findViewById(R.id.WaterOn);
        W_OFF = findViewById(R.id.WaterOff);

        W_ON.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseReference.child("water").child("Power").setValue("on");
            }
        });

        W_OFF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseReference.child("water").child("Power").setValue("on");
            }
        });*/



        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                Fragment fragment = null;
                switch (position){
                    case 0:
                        Light light = new Light();
                        return light;
                    case 1:
                        Water water = new Water();
                        return water;
                    default:
                        return null;
                }
            }

            @Override
            public int getCount() {
                return tabLayout.getTabCount();
            }
        });
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }
}