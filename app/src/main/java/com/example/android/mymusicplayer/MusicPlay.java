package com.example.android.mymusicplayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by fanny on 03/04/2018.
 */

public class MusicPlay extends AppCompatActivity {
    // Declare Variables
    TextView genre_txt;
    TextView record_txt;
    TextView artist_txt;
    TextView title_txt;
    ImageView img_record;
    String genre;
    String record;
    String artist;
    String title;
    int imgRessourceId;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play_music);
        // Get the intent from MusicListAdapter
        Intent i = getIntent();
        // Get the results of genre
        genre = i.getStringExtra("Genre");
        // Get the results of record
        record = i.getStringExtra("Record");
        // Get the results of artist
        artist = i.getStringExtra("Artist");
        // Get the results of title
        title = i.getStringExtra("Title");
        // Get the results of flag
        imgRessourceId = i.getIntExtra("Image", imgRessourceId);

        // Locate the TextViews in play_music.xml
        genre_txt = (TextView) findViewById(R.id.genre_text);
        record_txt = (TextView) findViewById(R.id.record_text);
        artist_txt = (TextView) findViewById(R.id.artist_text);
        title_txt = (TextView) findViewById(R.id.title_text);
        // Locate the ImageView in play_music.xml
        img_record = (ImageView) findViewById(R.id.image_record);

        // Load the results into the TextViews
        genre_txt.setText(genre);
        record_txt.setText(record);
        artist_txt.setText(artist);
        title_txt.setText(title);
        // Load the image into the ImageView
        img_record.setImageResource(imgRessourceId);
    }
}
