package com.example.banglaibetterme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Foods extends AppCompatActivity implements View.OnClickListener{
    private View vegetableDashboard,fruitDashboard,nutsDashboard,meatfishDashboard,immuneboosterfoodsDashboard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foods);

        vegetableDashboard=findViewById(R.id.vegetables);
        fruitDashboard=findViewById(R.id.fruits);
        nutsDashboard=findViewById(R.id.nuts);
        meatfishDashboard=findViewById(R.id.meat);
        immuneboosterfoodsDashboard=findViewById(R.id.immuneBoosterFoods);

        vegetableDashboard.setOnClickListener(this);
        fruitDashboard.setOnClickListener(this);
        nutsDashboard.setOnClickListener(this);

        meatfishDashboard.setOnClickListener(this);
        immuneboosterfoodsDashboard.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.vegetables:
                Intent intent = new Intent(Foods.this,VegetablesDashboard.class);
                startActivity(intent);
                break;
            case R.id.fruits:
                 intent = new Intent(Foods.this,FruitDashboard.class);
                startActivity(intent);
                break;
            case R.id.nuts:
                intent = new Intent(Foods.this,NutsDashboard.class);
                startActivity(intent);
                break;
            case R.id.meat:
                intent = new Intent(Foods.this,MeatFishDashboard.class);
                startActivity(intent);
                break;
            case R.id.immuneBoosterFoods:
                intent = new Intent(Foods.this,ImmunityBoostingFoodsDashboard.class);
                startActivity(intent);
                break;
        }

        }
}