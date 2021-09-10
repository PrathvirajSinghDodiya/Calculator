package com.example.calculator;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {
    Animation animationOne,animationTwo;
    TextView textView;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textView = findViewById(R.id.textcalci);
        imageView =findViewById(R.id.calci);
        animationOne = AnimationUtils.loadAnimation(this,R.anim.top_anim);
        animationTwo = AnimationUtils.loadAnimation(this,R.anim.bottom_anim);

        imageView.setAnimation(animationOne);
        textView.setAnimation(animationTwo);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity2.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        },1000);
    }
}