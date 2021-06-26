package com.example.banglaibetterme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.banglaibetterme.fruits.Apple;
import com.example.banglaibetterme.fruits.Banana;
import com.example.banglaibetterme.fruits.Grape;
import com.example.banglaibetterme.fruits.Guava;
import com.example.banglaibetterme.fruits.JackFruit;
import com.example.banglaibetterme.fruits.Lychee;
import com.example.banglaibetterme.fruits.Mango;

public class FruitDashboard extends AppCompatActivity implements View.OnClickListener {
    private View apple,banana,grape,guava,jackfruit,lichu,mango;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruit_dashboard);
        apple=findViewById(R.id.apple);
        banana=findViewById(R.id.banana);
        grape=findViewById(R.id.grape);
        guava=findViewById(R.id.guava);
        jackfruit=findViewById(R.id.jackfruit);
        lichu=findViewById(R.id.lychee);
        mango=findViewById(R.id.mango);



        apple.setOnClickListener(this);
        banana.setOnClickListener(this);
        grape.setOnClickListener(this);
        guava.setOnClickListener(this);
        jackfruit.setOnClickListener(this);
        lichu.setOnClickListener(this);
        mango.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.apple:
                Intent intent = new Intent(FruitDashboard.this, Apple.class);
                startActivity(intent);
                break;
            case R.id.banana:
                 intent = new Intent(FruitDashboard.this, Banana.class);
                startActivity(intent);
                break;
            case R.id.grape:
                intent = new Intent(FruitDashboard.this, Grape.class);
                startActivity(intent);
                break;
            case R.id.guava:
                intent = new Intent(FruitDashboard.this, Guava.class);
                startActivity(intent);
                break;
            case R.id.jackfruit:
                intent = new Intent(FruitDashboard.this, JackFruit.class);
                startActivity(intent);
                break;
            case R.id.lychee:
                intent = new Intent(FruitDashboard.this, Lychee.class);
                startActivity(intent);
                break;
            case R.id.mango:
                intent = new Intent(FruitDashboard.this, Mango.class);
                startActivity(intent);
                break;
    }
}}