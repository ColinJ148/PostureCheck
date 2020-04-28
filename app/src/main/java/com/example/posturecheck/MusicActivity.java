package com.example.posturecheck;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MusicActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayerZelda, mediaPlayerClassical, mediaPlayerLoFi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);
        mediaPlayerLoFi = MediaPlayer.create(this, R.raw.lofi);
        mediaPlayerClassical = MediaPlayer.create(this, R.raw.classical);
        mediaPlayerZelda = MediaPlayer.create(this, R.raw.zelda);
        final Button playLofi = findViewById(R.id.playLofi);
        final Button playClassical = findViewById(R.id.playClassical);
        final Button playZelda = findViewById(R.id.playZelda);
        Button stopBtn = findViewById(R.id.stopBtn);
        setAudioStreamType();


        stopBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopPlaying();
            }
        });
        playLofi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopPlaying();
                mediaPlayerLoFi.setLooping(false);
                mediaPlayerLoFi.start();
            }
        });

        playClassical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopPlaying();
                mediaPlayerClassical.setLooping(false);
                mediaPlayerClassical.start();
            }
        });

        playZelda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopPlaying();
                mediaPlayerZelda.setLooping(false);
                mediaPlayerZelda.start();
            }
        });
    }

    void stopPlaying() {
        if (mediaPlayerLoFi.isPlaying()) {
            mediaPlayerLoFi.stop();
        }
        if (mediaPlayerZelda.isPlaying()) {
            mediaPlayerZelda.stop();
        }
        if (mediaPlayerClassical.isPlaying()) {
            mediaPlayerClassical.stop();
        }
    }

    void setAudioStreamType() {
        mediaPlayerZelda.setAudioStreamType(AudioManager.STREAM_MUSIC);
        mediaPlayerClassical.setAudioStreamType(AudioManager.STREAM_MUSIC);
        mediaPlayerLoFi.setAudioStreamType(AudioManager.STREAM_MUSIC);
    }

}
