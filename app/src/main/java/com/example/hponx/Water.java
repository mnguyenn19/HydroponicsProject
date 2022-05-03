package com.example.hponx;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Water#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Water extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Water() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Water.
     */
    // TODO: Rename and change types and number of parameters
    public static Water newInstance(String param1, String param2) {
        Water fragment = new Water();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    private final DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
    Button waterLvlLow, waterLvlMedium, waterLvlHigh;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_water, container, false);

        waterLvlLow = view.findViewById(R.id.WaterLow);
        waterLvlMedium = view.findViewById(R.id.WaterMedium);
        waterLvlHigh = view.findViewById(R.id.WaterHigh);

        waterLvlLow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseReference.child("water").child("Power").setValue("low");
            }
        });

        waterLvlMedium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseReference.child("water").child("Power").setValue("medium");
            }
        });

        waterLvlHigh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseReference.child("water").child("Power").setValue("high");
            }
        });

        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_water, container, false);
        return view;
    }
}