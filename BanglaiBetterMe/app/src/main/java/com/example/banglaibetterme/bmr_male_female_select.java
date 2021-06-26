package com.example.banglaibetterme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class bmr_male_female_select extends AppCompatActivity implements View.OnClickListener {

    private Button male, female;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmr_male_female_select);

        male=findViewById(R.id.bmr_male);
        female=findViewById(R.id.bmr_female);
        male.setOnClickListener(this);
        female.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bmr_male:
                Intent intent = new Intent(bmr_male_female_select.this,bmr_male.class);
                startActivity(intent);
                break;

            case R.id.bmr_female:
                intent = new Intent(bmr_male_female_select.this,bmr_female.class);
                startActivity(intent);
                break;
    }
}}