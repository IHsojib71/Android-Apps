package com.example.banglaibetterme;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class BMICalculator extends AppCompatActivity  {
    private Button calculate;
    private EditText w, h;
    private TextView output;
    String BMI_result, calculation;

    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_calculator);

        calculate = findViewById(R.id.calculate_button);
        w = findViewById(R.id.weight);
        h = findViewById(R.id.height);
        output = findViewById(R.id.bmi_result);


    mAuth=FirebaseAuth.getInstance();


    }

    public void calculateBMI(View view) {



        String weightInKg = w.getText().toString();
        String heightIncm = h.getText().toString();

        if(weightInKg.isEmpty())
        {
            w.setError("ওজন দিন!");
            w.requestFocus();
            return;
        }
      else  if(heightIncm.isEmpty())
        {
            h.setError("উচ্চতা দিন!");
            h.requestFocus();
            return;
        }

        float weightValue = Float.parseFloat(weightInKg);
        float heightValue = Float.parseFloat(heightIncm) / 100;

        float bmi = weightValue / (heightValue * heightValue);

        if (bmi < 16) {
            BMI_result = "গুরুতর আন্ডার ওয়েইট";

        } else if (bmi < 18.5) {
            BMI_result = "আন্ডার ওয়েইট";
        } else if (bmi >= 18.5 && bmi <= 24.9) {
            BMI_result = "নরমাল";
        } else if (bmi >= 25 && bmi <= 29.9) {
            BMI_result = "ওভার ওয়েইট";
        } else if (bmi >= 30 && bmi <= 39.9) {
            BMI_result = "স্থুলাকার ওজন";
        } else if (bmi >= 40) {
            BMI_result = "অত্যাধিক স্থুলাকার ওজন ";
        }
        calculation = "" + bmi + " " + BMI_result;
        output.setText(calculation);

        BMI_data_pusher bmi_pusher = new BMI_data_pusher(calculation);
        FirebaseDatabase.getInstance().getReference("BMI")
                .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                .setValue(bmi_pusher).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                Toast.makeText(BMICalculator.this, "ডাটা সংরক্ষন হয়েছে!", Toast.LENGTH_SHORT).show();
            }
        });
    }





}
