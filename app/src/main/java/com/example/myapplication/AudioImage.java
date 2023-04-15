package com.example.myapplication;

import android.content.Intent;
import android.content.res.Resources;
import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View;


public class AudioImage extends Activity {

    MediaPlayer mp = new MediaPlayer();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.audio_image);

        setTitle("노래재생");

        Intent it = getIntent();
        String tag = it.getStringExtra("it_tag");

        TextView title = findViewById(R.id.title);
        ImageView song_image = findViewById(R.id.song_image);
        TextView lyrics = findViewById(R.id.lyrics);

        Resources res = getResources();

        int stringId;
        String myKey;

        stringId = res.getIdentifier("title" + tag, "string", getPackageName());
        myKey = res.getString(stringId);
        title.setText(myKey);

        stringId = res.getIdentifier("song_image" + tag, "string", getPackageName());
        myKey = res.getString(stringId);
        int id_image = res.getIdentifier(myKey, "drawable", getPackageName());
        song_image.setImageResource(id_image);

        stringId = res.getIdentifier("lyrics" + tag, "string", getPackageName());
        myKey = res.getString(stringId);
        lyrics.setText(myKey);

        stringId = res.getIdentifier("audio" + tag, "string", getPackageName());
        myKey = res.getString(stringId);
        int id_audio = res.getIdentifier(myKey, "raw", getPackageName());
        mp = MediaPlayer.create(this, id_audio);
        mp.setLooping(false);
        mp.start();
    }

    public void goBack(View v) {
        try {
            if (mp != null && mp.isPlaying()) {
                mp.stop();
            }
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } finally {
            if (mp != null) {
                mp.release();
            }
        }
        finish();
    }


}
