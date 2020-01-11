package com.example.hp.junscape;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class Achievement2 extends AppCompatActivity {

    ImageView banana1, can2, fish3, bananaDesc;
    int score;
    LinearLayout layoutDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_achievement2);

        banana1 = (ImageView) findViewById(R.id.banana1);
        can2 = (ImageView) findViewById(R.id.can2);
        fish3 = (ImageView) findViewById(R.id.fish3);
        bananaDesc = (ImageView) findViewById(R.id.bananaDesc);
        layoutDesc = (LinearLayout) findViewById(R.id.layoutDesc);


        SharedPreferences myScore = getSharedPreferences("myScore", Context.MODE_PRIVATE);
        score = myScore.getInt("score",0);
        Toast.makeText(this, "score = " + score, Toast.LENGTH_SHORT).show();

        if(score>=2){
            // SNACKBAR
            banana1.setImageResource(R.drawable.bbb);
            banana1.setClickable(true);

            banana1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    layoutDesc.setVisibility(View.VISIBLE);
                    bananaDesc.setVisibility(View.VISIBLE);
                }
            });


        }

        if (score >=25){
            can2.setImageResource(R.drawable.can);
            can2.setClickable(true);

            can2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    layoutDesc.setVisibility(View.VISIBLE);
                    bananaDesc.setVisibility(View.VISIBLE);
                }
            });
        }


    }



}
