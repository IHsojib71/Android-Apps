package com.example.banglaibetterme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Workout_dashboard extends AppCompatActivity implements View.OnClickListener {
    private View fullbody;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_dashboard);
        fullbody=findViewById(R.id.full_body_workout_male);

        fullbody.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.full_body_workout_male:
                Intent intent = new Intent(Workout_dashboard.this,Full_Body_plans_week.class);
                startActivity(intent);
                break;


        }

    }
}