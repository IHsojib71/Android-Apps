package com.example.banglaibetterme;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class bmr_male extends AppCompatActivity {
    private Button calculate;
    private EditText a,w,h;
    private TextView output,output2;
    String BMR_result,calculation,calculation2;
    private RadioGroup radioG;
    private RadioButton workoutFactor,b1,b2,b3,b4,b5;

    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmr_male);

        calculate=findViewById(R.id.calculate_button);
        a=findViewById(R.id.age);
        w=findViewById(R.id.weight);
        h=findViewById(R.id.height);
        output=findViewById(R.id.bmi_result);
        output2=findViewById(R.id.bmi_result2);
        radioG=findViewById(R.id.radioGroup);
        b1=findViewById(R.id.sedentary);
        b2=findViewById(R.id.lightly_active);
        b3=findViewById(R.id.moderately_active);
        b4=findViewById(R.id.very_active);
        b5=findViewById(R.id.super_active);

        mAuth=FirebaseAuth.getInstance();


    }
    public void calculateBMR(View view) {
        float workout_value= (float) 0.0;
        String ageInyears=a.getText().toString();
        String weightInKg=w.getText().toString();
        String heightIncm=h.getText().toString();

        if(ageInyears.isEmpty())
        {
            a.setError("বয়স দিন!");
            a.requestFocus();
            return;
        }
        else if(weightInKg.isEmpty())
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

        float weightValue=Float.parseFloat(weightInKg);
        float ageValue=Float.parseFloat(ageInyears);
        float heightValue=Float.parseFloat(heightIncm);

        int selectedButton=radioG.getCheckedRadioButtonId();
        workoutFactor=findViewById(selectedButton);

        if(workoutFactor==b1){
            workout_value= (float) 1.2;
        }
        else if(workoutFactor==b2){
            workout_value= (float) 1.375;
        }
        else if(workoutFactor==b3){
            workout_value= (float) 1.55;
        }
        else if(workoutFactor==b4){
            workout_value= (float) 1.725;
        }
        else if(workoutFactor==b5){
            workout_value= (float) 1.9;
        }

        float bmr = (float) ((10*weightValue) + (6.25 * heightValue) - (5 * ageValue)+5);

        float final_bmr= (float) (bmr * workout_value);
        calculation=""+bmr+"\n";
        output.setText(calculation);

        calculation2=""+final_bmr+"\n";
        output2.setText(calculation2);



        BMR_data_pusher bmr_pusher=new BMR_data_pusher(calculation2);
        FirebaseDatabase.getInstance().getReference("BMR")
                .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                .setValue(bmr_pusher).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                Toast.makeText(bmr_male.this,"ডাটা সংরক্ষন হয়েছে!",Toast.LENGTH_SHORT).show();
            }
        });



    }



}