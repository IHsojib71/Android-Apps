package com.example.banglaibetterme;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignIn extends AppCompatActivity implements View.OnClickListener {
    private TextInputEditText uEmail, uPassword;
    private TextView CallUpSignup,titleText,forgotPassword;
    private ImageView image;
    private Button signIn;
    private ProgressBar progressB;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        mAuth = FirebaseAuth.getInstance();

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        CallUpSignup=findViewById(R.id.registrationActivity);
        image=findViewById(R.id.logoSignIn);
        titleText=findViewById(R.id.title_welcome);
        signIn=findViewById(R.id.signInButton);
        uEmail=findViewById(R.id.login_email);
        uPassword=findViewById(R.id.login_password);
        progressB=findViewById(R.id.progressBar);
        forgotPassword=findViewById(R.id.forgetButton);
        
        signIn.setOnClickListener(this);
        forgotPassword.setOnClickListener(this);


        CallUpSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignIn.this,SignUp.class);

                Pair[] pairs = new Pair[2];
                pairs[0]=new Pair<View,String>(image,"logo_image");
                pairs[1]=new Pair<View,String>(titleText,"logo_text");

                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(SignIn.this,pairs);
                startActivity(intent,options.toBundle());

            }
        });
      
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.signInButton:
                userLogin();

                break;

            case R.id.forgetButton:
                Intent intent = new Intent(SignIn.this,ForgotPassword.class);
                startActivity(intent);

                break;


        }
    }

    private void userLogin() {
        String email = uEmail.getText().toString().trim();
        String password = uPassword.getText().toString().trim();
        //checking the validity of the email
        if(email.isEmpty())
        {
            uEmail.setError("ইমেইল দিন!");
            uEmail.requestFocus();
            return;
        }

        if(!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            uEmail.setError("সঠিক ইমেইল দিন!");
            uEmail.requestFocus();
            return;
        }

        //checking the validity of the password
        if(password.isEmpty())
        {
            uPassword.setError("পাসওয়ার্ড দিন!");
            uPassword.requestFocus();
            return;
        }
        if(password.length()<6){
            uPassword.setError("কমপক্ষে ৬ অক্ষরের পাসওয়ার্ড দিন!");
            uPassword.requestFocus();
            return;
        }
        progressB.setVisibility(View.VISIBLE);

        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressB.setVisibility(View.GONE);
                if(task.isSuccessful()){

                    finish();
                    Toast.makeText(getApplicationContext(),"লগিন সম্পূর্ন হয়েছে!",Toast.LENGTH_LONG).show();
                    Intent intent=new Intent(getApplicationContext(),Dashboard.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(getApplicationContext(),"লগিন হয়নি আবার চেষ্টা করুন!",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
