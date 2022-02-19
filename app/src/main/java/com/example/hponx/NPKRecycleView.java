package com.example.hponx;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class NPKRecycleView extends AppCompatActivity implements RViewInterface{

    ArrayList<ElementsModel> elementsModels = new ArrayList<>();
    int[] elementsImages = {R.drawable.plantgrowth, R. drawable.nitrogenn, R.drawable.phorphous, R.drawable.potassiumk};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_npkrecycle_view);

        RecyclerView recyclerView = findViewById(R.id.hRecyclerView);

        setUpElementsModels();
        NPK_RecycleViewAdapter adapter = new NPK_RecycleViewAdapter(this, elementsModels, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void setUpElementsModels(){
        String[] elementsNames = getResources().getStringArray(R.array.elements_full_name);
        String[] elementsAbbreviations = getResources().getStringArray(R.array.elements_abrev_name);
        String[] elementsDescriptions = getResources().getStringArray(R.array.elements_descrip);

        for (int i = 0; i < elementsNames.length; i++){
            elementsModels.add(new ElementsModel(elementsNames[i],
                    elementsAbbreviations[i],
                    elementsImages[i],elementsDescriptions[i]));
        }

    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(NPKRecycleView.this, RViewInterface.class); //RViewInterface could be wrong

        intent.putExtra("NAME", elementsModels.get(position).getElementName());
        intent.putExtra("ABBREV", elementsModels.get(position).getElementAbbreviation());
        intent.putExtra("DESCRIPTION", elementsModels.get(position).getDescription());
        intent.putExtra("IMAGE", elementsModels.get(position).getImage());

        startActivity(intent);
    }
}