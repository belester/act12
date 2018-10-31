package com.example.belester.act12;

import android.annotation.SuppressLint;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.widget.VideoView;
import android.widget.MediaController;
import android.os.Bundle;


public class MainActivity extends AppCompatActivity {
    private VideoView mVideoView;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Binding
        mVideoView = findViewById(R.id.videoview);

        //Set Video View to Media Controller
        MediaController controller = new MediaController(this);
        controller.setMediaPlayer(mVideoView);

        //Set Media Controller to Video View
        mVideoView.setMediaController(controller);
    }

    private void initializePlayer(){
        mVideoView.setVideoPath("https://www.ebookfrenzy.com/android_book/movie.mp4");
        mVideoView.start();
    }

    private void releasePlayer() {mVideoView.stopPlayback();}


    @Override
    protected void onStop(){
        super.onStop();
        releasePlayer();
    }

    @Override
    protected void onPause(){
        super.onPause();

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N)
        {
            mVideoView.pause();
        }
    }
}