package com.example.banglaibetterme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class VegetablesDashboard extends AppCompatActivity implements View.OnClickListener {
    private View cauliflower,cabbage,carrot,potato,ladyfinger,tomato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vegetables_dashboard);

        cauliflower=findViewById(R.id.cauliflower);
        cabbage=findViewById(R.id.cabbage);
        carrot=findViewById(R.id.carrots);
        potato=findViewById(R.id.potato);
        ladyfinger=findViewById(R.id.ladyFinger);
        tomato=findViewById(R.id.tomato);


        cauliflower.setOnClickListener(this);
        cabbage.setOnClickListener(this);
        carrot.setOnClickListener(this);
        potato.setOnClickListener(this);
        ladyfinger.setOnClickListener(this);
        tomato.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.cauliflower:
                Intent intent = new Intent(VegetablesDashboard.this,CauliFlower.class);
                startActivity(intent);
                break;

            case R.id.cabbage:
                 intent = new Intent(VegetablesDashboard.this,Cabbage.class);
                startActivity(intent);
                break;
            case R.id.carrots:
                intent = new Intent(VegetablesDashboard.this,Carrot.class);
                startActivity(intent);
                break;
            case R.id.potato:
                intent = new Intent(VegetablesDashboard.this,Potato.class);
                startActivity(intent);
                break;
            case R.id.ladyFinger:
                intent = new Intent(VegetablesDashboard.this,LadyFinger.class);
                startActivity(intent);
                break;
            case R.id.tomato:
                intent = new Intent(VegetablesDashboard.this,Tomato.class);
                startActivity(intent);
                break;
    }
}}