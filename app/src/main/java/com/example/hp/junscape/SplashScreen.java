package com.example.hp.junscape;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;

import pl.droidsonroids.gif.GifImageView;

public class SplashScreen extends Activity {

    GifImageView gifSplash;
    private static int SPLASH_TIME_OUT = 6000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        gifSplash = (GifImageView) findViewById(R.id.gifSplash);

//        final Animation in = new AlphaAnimation(0.0f,1.0f);
//        in.setDuration(3000);

//        gifSplash.setAnimation(in);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(intent);
                finish();

            }
        },SPLASH_TIME_OUT);

    }
}
