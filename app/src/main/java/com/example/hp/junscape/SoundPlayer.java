package com.example.hp.junscape;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;

public class SoundPlayer {

    private static SoundPool soundPool;
    private static int hitSound;
    private static int errorSound;
    private static int gameOverSound;
    private static int clickedSound;

    public SoundPlayer(Context contex) {
        //SoundPool(int maxStreams, int streamType, int srcQuality)
        soundPool = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);
        hitSound = soundPool.load(contex, R.raw.hit, 1);
        errorSound = soundPool.load(contex, R.raw.error, 1);
        gameOverSound = soundPool.load(contex, R.raw.gameover, 1);
        clickedSound = soundPool.load(contex, R.raw.clicked, 1);
    }

    public void playHitSound() {

        //play(int soundID, float leftVolume, float rightVolume, int priority, int loop, float rate)
        soundPool.play(hitSound, 1.0f, 1.0f, 1, 0, 1.0f);
    }

    public void playErrorSound() {
        //play(int soundID, float leftVolume, float rightVolume, int priority, int loop, float rate)
        soundPool.play(errorSound, 1.0f, 1.0f, 1, 0, 1.0f);
    }

    public void playGameOverSound() {
        //play(int soundID, float leftVolume, float rightVolume, int priority, int loop, float rate)
        soundPool.play(gameOverSound, 1.0f, 1.0f, 1, 0, 1.0f);
    }

    public void playClickedSound() {
        //play(int soundID, float leftVolume, float rightVolume, int priority, int loop, float rate)
        soundPool.play(clickedSound, 1.0f, 1.0f, 1, 0, 1.0f);
    }

}
