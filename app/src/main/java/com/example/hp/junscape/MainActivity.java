package com.example.hp.junscape;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.support.v4.view.ViewPager;
import android.widget.Toast;

import java.util.Timer;

import pl.droidsonroids.gif.GifImageView;

public class MainActivity extends AppCompatActivity {

    int count = 0;

    //Image
    private ImageView picStart, picAchievements, picAbout;

    //Vibrator
    Vibrator vibrator;

    //Score
    private TextView highScoreLabel;
    private int score = 0, highScore;
    private SharedPreferences settings;

    //Sound players
    private SoundPlayer sound;
    private MediaPlayer mainBGMusic, homeBGMusic;

    //Button
    private Button btnSettings, btnMute, btnBack;

    private RelativeLayout settingsFrame;

    boolean isPlaying = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);

        sound = new SoundPlayer(this);
        mainBGMusic = MediaPlayer.create(this, R.raw.maingamesound);
        homeBGMusic = MediaPlayer.create(this, R.raw.homesound);

        picStart = (ImageView) findViewById(R.id.picStart);
        picAchievements = (ImageView) findViewById(R.id.picAchievements);
        picAbout = (ImageView) findViewById(R.id.picAbout);

        //Button
        btnSettings = (Button) findViewById(R.id.btnSettings);
        btnMute = (Button) findViewById(R.id.btnMute);
        btnBack = (Button) findViewById(R.id.btnBack);

        settingsFrame = (RelativeLayout) findViewById(R.id.SettingsLayout);

        //Score
        highScoreLabel = (TextView) findViewById(R.id.highScoreLabel);

        //High Score
        settings = getSharedPreferences("GAME_DATA", Context.MODE_PRIVATE);
        highScore = settings.getInt("HIGH_SCORE", 0);
        highScoreLabel.setText("BEST: " + highScore);

        //Music
        homeBGMusic.start();
        homeBGMusic.setLooping(true);

        //Load score
        SharedPreferences myScore = this.getSharedPreferences("myScore", Context.MODE_PRIVATE);
        score = myScore.getInt("score", 0);


        picAchievements.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(MainActivity.this, Achievement2.class);
                startActivity(in);
            }
        });


        picStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sound.playClickedSound();
                homeBGMusic.stop();
                homeBGMusic.prepareAsync();
                Intent intent = new Intent(MainActivity.this, GamePage.class);
                startActivity(intent);
            }
        });


        picAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, About.class);
                startActivity(intent);
            }
        });

        btnSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                settingsFrame.setVisibility(View.VISIBLE);

                picStart.setVisibility(View.GONE);
                picAbout.setVisibility(View.GONE);
                picAchievements.setVisibility(View.GONE);

                btnMute.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (isPlaying == false) {
                            mainBGMusic.setVolume(0, 0);
                            homeBGMusic.setVolume(0, 0);
                            btnMute.setText("UNMUTE");
                            isPlaying = true;
                        } else {
                            mainBGMusic.setVolume(1, 1);
                            homeBGMusic.setVolume(1, 1);
                            btnMute.setText("MUTE");
                            isPlaying = false;
                        }
                    }
                });
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                settingsFrame.setVisibility(View.GONE);
                picStart.setVisibility(View.VISIBLE);
                picAbout.setVisibility(View.VISIBLE);
                picAchievements.setVisibility(View.VISIBLE);
            }
        });


    }

    @Override
    public void onBackPressed() {
        count++;
        Toast.makeText(this, "Press again to exit", Toast.LENGTH_SHORT).show();
        if (count == 2) {
            finish();
            System.exit(0);
        }
    }

}