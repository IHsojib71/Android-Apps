package com.example.banglaibetterme;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private static int SPLASH_SCREEN=3000;

    Animation topAnim, bottomAnim;
    ImageView image;
    TextView title, slogan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        mAuth=FirebaseAuth.getInstance();

        //Animation
        topAnim= AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottomAnim= AnimationUtils.loadAnimation(this,R.anim.bottom_animation);

        image=findViewById(R.id.imageView);
        title=findViewById(R.id.textView1);
        slogan=findViewById(R.id.textView2);
        image.setAnimation(topAnim);
        title.setAnimation(bottomAnim);
        slogan.setAnimation(bottomAnim);




    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseUser mFirebaseUser=mAuth.getCurrentUser();
        if(mFirebaseUser!=null){
            //user already logged in so go to dashboard
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(MainActivity.this,Dashboard.class);
                    Pair[] pairs=new Pair[2];
                    pairs[0]=new Pair<View,String>(image,"logo_image");
                    pairs[1]=new Pair<View,String>(title,"logo_text");
                    ActivityOptions options=ActivityOptions.makeSceneTransitionAnimation(MainActivity.this,pairs);
                    startActivity(intent,options.toBundle());
                    finish();
                }
            },SPLASH_SCREEN);

        }
        else{
            //no user so login
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(MainActivity.this,SignIn.class);
                    Pair[] pairs=new Pair[2];
                    pairs[0]=new Pair<View,String>(image,"logo_image");
                    pairs[1]=new Pair<View,String>(title,"logo_text");
                    ActivityOptions options=ActivityOptions.makeSceneTransitionAnimation(MainActivity.this,pairs);
                    startActivity(intent,options.toBundle());
                    finish();
                }
            },SPLASH_SCREEN);

        }
    }
}