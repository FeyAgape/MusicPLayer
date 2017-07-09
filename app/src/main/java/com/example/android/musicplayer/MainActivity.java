package com.example.android.musicplayer;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //declare MediaPlayer as a global variable
   private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer = MediaPlayer.create(this, R.raw.bebe);

       /* ImageButton resetButton = (ImageButton) findViewById(R.id.button);
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.reset();

            }
        });*/

        ImageButton playButton = (ImageButton) findViewById(R.id.button2);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mediaPlayer.start();
                //allows you to set a callback once the music player has finished playing the media file
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        Toast.makeText(MainActivity.this, "I'm Finished", Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });

        ImageButton pauseButton = (ImageButton) findViewById(R.id.button3);
        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.pause();

            }
        });

        /*ImageButton volumeButton = (ImageButton) findViewById(R.id.button4);
        volumeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.stop();

            }
        });*/

    }
}
