package com.example.myapplication;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("노래목록");

    }

    public void play(View v){
        int id = v.getId();
        LinearLayout layout = findViewById(id);//캐스팅 불필요

        String tag = (String)layout.getTag();

        Intent it = new Intent(this, AudioImage.class);
        it.putExtra("it_tag", tag);
        startActivity(it);
    }
}