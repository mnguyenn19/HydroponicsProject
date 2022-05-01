package com.example.hponx;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class plant extends AppCompatActivity implements View.OnClickListener {
    public CardView pCardBasil, pCardBeans, pCardBlueberry, pCardCantaloupe, pCardCelery, pCardCilantro, pCardCucumber, pCardGrape, pCardLettuce, pCardPotato, pCardRosemary, pCardSquash, pCardStrawberry, pCardTomato, pCardWatermelon, pCardPlant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plant);

        pCardBasil = (CardView) findViewById(R.id.pbasil);
        pCardBeans = (CardView) findViewById(R.id.pbeans);
        pCardBlueberry = (CardView) findViewById(R.id.pblueberry);
        pCardCantaloupe = (CardView) findViewById(R.id.pcantaloupe);
        pCardCelery = (CardView) findViewById(R.id.pcelery);
        pCardCilantro = (CardView) findViewById(R.id.pcilantro);
        pCardCucumber = (CardView) findViewById(R.id.pcucumber);
        pCardGrape = (CardView) findViewById(R.id.pgrape);
        pCardLettuce = (CardView) findViewById(R.id.plettuce);
        pCardPotato = (CardView) findViewById(R.id.ppotato);
        pCardRosemary = (CardView) findViewById(R.id.prosemary);
        pCardSquash = (CardView) findViewById(R.id.psquash);
        pCardStrawberry = (CardView) findViewById(R.id.pstrawberry);
        pCardTomato = (CardView) findViewById(R.id.ptomato);
        pCardWatermelon = (CardView) findViewById(R.id.pwatermelon);
        pCardPlant = (CardView) findViewById(R.id.pplant);

        pCardBasil.setOnClickListener(this);
        pCardBeans.setOnClickListener(this);
        pCardBlueberry.setOnClickListener(this);
        pCardCantaloupe.setOnClickListener(this);
        pCardCelery.setOnClickListener(this);
        pCardCilantro.setOnClickListener(this);
        pCardCucumber.setOnClickListener(this);
        pCardGrape.setOnClickListener(this);
        pCardLettuce.setOnClickListener(this);
        pCardPotato.setOnClickListener(this);
        pCardRosemary.setOnClickListener(this);
        pCardSquash.setOnClickListener(this);
        pCardStrawberry.setOnClickListener(this);
        pCardTomato .setOnClickListener(this);
        pCardWatermelon.setOnClickListener(this);
        pCardPlant.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent i;

        switch(view.getId()){
            case R.id.pbasil:
                i = new Intent(this,plant_basil.class);
                startActivity(i);
                break;

            case R.id.pbeans:
                i = new Intent(this,plant_beans.class);
                startActivity(i);
                break;

            case R.id.pblueberry:
                i = new Intent(this,plant_blueberry.class);
                startActivity(i);
                break;

            case R.id.pcantaloupe:
                i = new Intent(this,plant_cantaloupe.class);
                startActivity(i);
                break;

            case R.id.pcelery:
                i = new Intent(this,plant_celery.class);
                startActivity(i);
                break;

            case R.id.pcilantro:
                i = new Intent(this,plant_cilantro.class);
                startActivity(i);
                break;

            case R.id.pcucumber:
                i = new Intent(this,plant_cucumber.class);
                startActivity(i);
                break;

            case R.id.pgrape:
                i = new Intent(this,plant_grape.class);
                startActivity(i);
                break;

            case R.id.plettuce:
                i = new Intent(this,plant_lettuce.class);
                startActivity(i);
                break;

            case R.id.ppotato:
                i = new Intent(this,plant_potato.class);
                startActivity(i);
                break;

            case R.id.prosemary:
                i = new Intent(this,plant_rosemary.class);
                startActivity(i);
                break;

            case R.id.psquash:
                i = new Intent(this,plant_squash.class);
                startActivity(i);
                break;

            case R.id.pstrawberry:
                i = new Intent(this,plant_strawberry.class);
                startActivity(i);
                break;

            case R.id.ptomato:
                i = new Intent(this,plant_tomato.class);
                startActivity(i);
                break;

            case R.id.pwatermelon:
                i = new Intent(this,plant_watermelon.class);
                startActivity(i);
                break;

            case R.id.pplant:
                i = new Intent(this,plant_plant.class);
                startActivity(i);
                break;
        }
    }
}