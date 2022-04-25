package com.example.hponx;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class NPKRecycleView extends AppCompatActivity {

    RecyclerView recyclerView;
    NPK_RecycleViewAdapter npkAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_npkrecycle_view);

        recyclerView = (RecyclerView)findViewById(R.id.hRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<npk_model> options =
                new FirebaseRecyclerOptions.Builder<npk_model>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("data"), npk_model.class)
                        .build();

        npkAdapter = new NPK_RecycleViewAdapter(options);
        recyclerView.setAdapter(npkAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        npkAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        npkAdapter.stopListening();
    }
}

