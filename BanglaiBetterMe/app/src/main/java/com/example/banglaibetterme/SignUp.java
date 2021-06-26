package com.example.banglaibetterme;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.database.FirebaseDatabase;

public class SignUp extends AppCompatActivity implements View.OnClickListener {
    private TextInputEditText userfullname, userAge, userEmail, userPassword;
    private Button signUpButton;
    private TextView loginScreenBack;
    private FirebaseAuth mAuth;
    private ProgressBar progressB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mAuth = FirebaseAuth.getInstance();
        userfullname=findViewById(R.id.registrationName);
        userAge=findViewById(R.id.registrationAge);
        userEmail=findViewById(R.id.registrationEmail);
        userPassword=findViewById(R.id.registrationPassword);
        signUpButton=findViewById(R.id.signUpB);
        loginScreenBack=findViewById(R.id.loginBack);
        progressB=findViewById(R.id.progressBar);

        signUpButton.setOnClickListener(this);
        loginScreenBack.setOnClickListener(this);


    }


    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.signUpB:
                userRegister();
                break;

            case R.id.loginBack:
                Intent intent = new Intent(getApplicationContext(),SignIn.class);
                startActivity(intent);
                break;

        }
    }

    private void userRegister() {
        final String name = userfullname.getText().toString();
        final String age = userAge.getText().toString().trim();
        final String email = userEmail.getText().toString().trim();
        String password = userPassword.getText().toString().trim();
   //checking name
        if(name.isEmpty())
        {
            userfullname.setError("আপনার নাম দিন!");
            userfullname.requestFocus();
            return;
        }
        //username
        if(age.isEmpty())
        {
            userAge.setError("আপনার বয়স দিন!");
            userAge.requestFocus();
            return;
        }
        if(age.length()>=3)
        {
            userAge.setError("বয়স এত বেশি হয়না!");
            userAge.requestFocus();
            return;
        }

        //checking the validity of the email
        if(email.isEmpty())
        {
            userEmail.setError("ইমেইল দিন!");
            userEmail.requestFocus();
            return;
        }

        if(!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            userEmail.setError("সঠিক ইমেইল দিন!");
            userEmail.requestFocus();
            return;
        }

        //checking the validity of the password
        if(password.isEmpty())
        {
            userPassword.setError("পাসওয়ার্ড দিন!");
            userPassword.requestFocus();
            return;
        }
        if(password.length()<6){
            userPassword.setError("কমপক্ষে ৬ অক্ষরের পাসওয়ার্ড দিন!");
            userPassword.requestFocus();
        }

        progressB.setVisibility(View.VISIBLE);

        mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressB.setVisibility(View.GONE);
                if (task.isSuccessful()) {

                    finish();
                    Toast.makeText(getApplicationContext(),"নিবন্ধন সফল হয়েছে!",Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(getApplicationContext(),Dashboard.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);

                    User user =new User(name,age,email);
                    FirebaseDatabase.getInstance().getReference("Users")
                           .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                                            .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(getApplicationContext(),"নিবন্ধন সফল হয়েছে!",Toast.LENGTH_SHORT).show();
                            }
                            else{
                                Toast.makeText(getApplicationContext(),"নিবন্ধন হয়নি আবার চেষ্টা করুন!",Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

                } else {
                   if(task.getException() instanceof FirebaseAuthUserCollisionException)
                   {
                       Toast.makeText(getApplicationContext(),"এই ইউজার আগে থেকেই আছে!",Toast.LENGTH_SHORT).show();
                   }
                   else{
                       Toast.makeText(getApplicationContext(),"Error : "+task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                   }
                }
            }
        });



    }


}



