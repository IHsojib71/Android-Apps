package com.example.banglaibetterme;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;

public class Dashboard extends AppCompatActivity implements View.OnClickListener {
    private View bmiB,waterR,dietKnowledge,bmr,pedo,exercise,foods;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        mAuth=FirebaseAuth.getInstance();

        bmiB=findViewById(R.id.bmi_button);
        waterR=findViewById(R.id.waterReminder);
        dietKnowledge=findViewById(R.id.basicDietKnowledge);
        bmr=findViewById(R.id.bmr_calculator);

        exercise=findViewById(R.id.exercises);
        foods=findViewById(R.id.food);

        bmiB.setOnClickListener(this);
        waterR.setOnClickListener(this);
        dietKnowledge.setOnClickListener(this);
        bmr.setOnClickListener(this);

        exercise.setOnClickListener(this);
        foods.setOnClickListener(this);



    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.bmi_button:
                Intent intent = new Intent(Dashboard.this,BMICalculator.class);
                startActivity(intent);
                break;

            case R.id.waterReminder:
                 intent = new Intent(Dashboard.this,water_reminder.class);
                startActivity(intent);
                break;
            case R.id.basicDietKnowledge:
                intent = new Intent(Dashboard.this,DietBasicKnowledge.class);
                startActivity(intent);
                break;

            case R.id.bmr_calculator:
                intent = new Intent(Dashboard.this,bmr_male_female_select.class);
                startActivity(intent);
                break;


            case R.id.exercises:
                intent = new Intent(Dashboard.this,Workout_gender.class);
                startActivity(intent);
                break;
            case R.id.food:
                intent = new Intent(Dashboard.this,Foods.class);
                startActivity(intent);
                break;
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_layout,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.signOutMenu){
            FirebaseAuth.getInstance().signOut();
            finish();
            Intent intent = new Intent(getApplicationContext(),SignIn.class);
            startActivity(intent);
        }
        if(item.getItemId()==R.id.user_profile){
            Intent intent = new Intent(getApplicationContext(),Profile.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}