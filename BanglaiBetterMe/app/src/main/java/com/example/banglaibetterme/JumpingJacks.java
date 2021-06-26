package com.example.banglaibetterme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class JumpingJacks extends AppCompatActivity implements View.OnClickListener{
    private ImageView home, workout_list,weekly_workout,nextButton,previousButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jumping_jacks);

        home=findViewById(R.id.home_button);
        workout_list=findViewById(R.id.workout_dashboard);
        weekly_workout=findViewById(R.id.weekly_workout);
        nextButton=findViewById(R.id.nextButton);
        previousButton=findViewById(R.id.backward_button);

        home.setOnClickListener(this);
        workout_list.setOnClickListener(this);
        weekly_workout.setOnClickListener(this);
        nextButton.setOnClickListener(this);
        previousButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.home_button:
                Intent intent = new Intent(JumpingJacks.this,Dashboard.class);
                startActivity(intent);
                finish();
                break;

            case R.id.workout_dashboard:
                 intent = new Intent(JumpingJacks.this,Workout_dashboard.class);
                startActivity(intent);
                finish();
                break;
            case R.id.weekly_workout:
                intent = new Intent(JumpingJacks.this,Full_Body_plans_week.class);
                startActivity(intent);
                finish();
                break;
            case R.id.nextButton:
                intent = new Intent(JumpingJacks.this,Incline_push_ups.class);
                startActivity(intent);
                finish();
                break;
            case R.id.backward_button:
                intent = new Intent(JumpingJacks.this,Full_Body_plans_week.class);
                startActivity(intent);
                finish();
                break;

        }
    }
}