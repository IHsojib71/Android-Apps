package com.example.banglaibetterme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Full_Body_plans_week extends AppCompatActivity implements View.OnClickListener {
    private View first,second,third,fourth,fifth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full__body_plans_week);
        first=findViewById(R.id.first_week_one);




        first.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.first_week_one:
                Intent intent = new Intent(Full_Body_plans_week.this,JumpingJacks.class);
                startActivity(intent);
                break;


        }
    }
}