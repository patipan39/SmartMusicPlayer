package com.dev.ipati.musicplayerlibrary;

import android.media.MediaPlayer;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.dev.ipati.smartMusicPlayerLibrary.SmartMediaPlayer;

import java.io.File;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    SmartMediaPlayer smartMediaPlayer;
    MediaPlayer mMediaPlayer;
    Button mPlay, mPause, mNext, mPrev;
    ImageView imAlbum;
    ArrayList<File> listFilePlayer = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPlay = (Button) findViewById(R.id.bt_play);
        mPause = (Button) findViewById(R.id.bt_pause);
        mNext = (Button) findViewById(R.id.bt_next);
        mPrev = (Button) findViewById(R.id.bt_prev);
        imAlbum = (ImageView) findViewById(R.id.im_album);
        File file = new File(Environment.getExternalStorageDirectory() + "/Music");
        for (File list : file.listFiles()) {
            if (list.getName().endsWith(".mp3")) {
                listFilePlayer.add(list);
            }
        }

        smartMediaPlayer = new SmartMediaPlayer(getApplicationContext(), mMediaPlayer, R.raw.labanoon);
        smartMediaPlayer.setBitmapImageCover(getApplicationContext()
                , R.mipmap.ic_launcher, imAlbum
                , true);

        mPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                smartMediaPlayer.OnMusicStartListener();
            }
        });

        mPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                smartMediaPlayer.OnMusicPauseListener();
            }
        });

        mNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                smartMediaPlayer.OnMusicNextListener();
            }
        });

        mPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                smartMediaPlayer.OnMusicPrevListener();
            }
        });
    }

}
