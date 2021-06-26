package com.example.banglaibetterme;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Profile extends AppCompatActivity {
    private FirebaseUser user,userBMI,userBMR;
    private DatabaseReference reference,referenceBMI,referenceBMR;

    private String userID,userIDBMI,userIDBMR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        user = FirebaseAuth.getInstance().getCurrentUser();
        reference= FirebaseDatabase.getInstance().getReference("Users");
        userID=user.getUid();

        userBMI = FirebaseAuth.getInstance().getCurrentUser();
        referenceBMI= FirebaseDatabase.getInstance().getReference("BMI");
        userIDBMI=user.getUid();

        userBMR = FirebaseAuth.getInstance().getCurrentUser();
        referenceBMR= FirebaseDatabase.getInstance().getReference("BMR");
        userIDBMR=user.getUid();




        final TextView proUserName = (TextView)findViewById(R.id.profilename);
        final TextView proEmail = (TextView)findViewById(R.id.profileEmail);
        final TextView proAge = (TextView)findViewById(R.id.profileAge);
        final TextView lastBMI=(TextView)findViewById(R.id.lastBMIprofile);
        final TextView lastBMR=(TextView)findViewById(R.id.lastBMRprofile);

        reference.child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User userProfile=snapshot.getValue(User.class);

                if(userProfile!=null){
                    String fullName=userProfile.fullName;
                    String email=userProfile.email;
                    String age=userProfile.age;

                    proUserName.setText(fullName);
                    proEmail.setText(email);
                    proAge.setText(age);


                }



            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(Profile.this,"Something wrong happend!",Toast.LENGTH_LONG).show();
            }
        });




        //BMI

        referenceBMI.child(userIDBMI).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                BMI_data_pusher bmi_pusher=snapshot.getValue(BMI_data_pusher.class);

                if(bmi_pusher!=null){
                    String bmi_result= bmi_pusher.bmi_result;
                    lastBMI.setText(bmi_result);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(Profile.this,"আবার চেষ্টা করুন!",Toast.LENGTH_LONG).show();
            }
        });

        //BMR


        referenceBMR.child(userIDBMR).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                BMR_data_pusher bmr_pusher=snapshot.getValue(BMR_data_pusher.class);

                if(bmr_pusher!=null){
                    String bmi_result= bmr_pusher.bmr_result;
                    lastBMR.setText(bmi_result);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(Profile.this,"আবার চেষ্টা করুন!",Toast.LENGTH_LONG).show();
            }
        });










    }
}