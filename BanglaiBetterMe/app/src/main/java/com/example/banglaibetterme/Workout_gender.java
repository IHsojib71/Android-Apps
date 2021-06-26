package com.example.banglaibetterme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Workout_gender extends AppCompatActivity implements View.OnClickListener{
    private Button male, female;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_gender);
        male=findViewById(R.id.bmr_male);
        female=findViewById(R.id.bmr_female);
        male.setOnClickListener(this);
        female.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bmr_male:
                Intent intent = new Intent(Workout_gender.this,Workout_dashboard.class);
                startActivity(intent);
                break;

            case R.id.bmr_female:
                intent = new Intent(Workout_gender.this,Workout_dashboard_female.class);
                startActivity(intent);
                break;
    }
}}