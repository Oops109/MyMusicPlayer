package com.example.android.mymusicplayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Locale;

/**
 * Created by fanny on 31/03/2018.
 */

public class TitleActivity extends AppCompatActivity {

    EditText editText;
    String mGenre1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        android.support.v7.app.ActionBar actionBar =getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.song_list);

        final ArrayList<Music> musicArrayList = new ArrayList<Music>();
        musicArrayList.add(new Music("Jazz", "Time Out", "Dave Brubeck", "Take Five", R.drawable.time_out));
        musicArrayList.add(new Music("Jazz", "Time Out", "Dave Brubeck", "Blue Rondo a la Turk", R.drawable.time_out));
        musicArrayList.add(new Music("Jazz", "Time Out", "Dave Brubeck", "Strange Meadow Lark", R.drawable.time_out));
        musicArrayList.add(new Music("Jazz", "Time Out", "Dave Brubeck", "Three to Get Ready", R.drawable.time_out));
        musicArrayList.add(new Music("Jazz", "Time Out", "Dave Brubeck", "Kathy's Waltz", R.drawable.time_out));
        musicArrayList.add(new Music("Jazz", "Time Out", "Dave Brubeck", "Everybody's Jumpin", R.drawable.time_out));
        musicArrayList.add(new Music("Blues", "Blues", "Jimmy Hendrix", "Hear My Train A Comin'", R.drawable.blues_album));
        musicArrayList.add(new Music("Blues", "Blues", "Jimmy Hendrix", "Born Under a Bad Sign", R.drawable.blues_album));
        musicArrayList.add(new Music("Blues", "Blues", "Jimmy Hendrix", "Red House", R.drawable.blues_album));
        musicArrayList.add(new Music("Blues", "Blues", "Jimmy Hendrix", "Catfish Blues", R.drawable.blues_album));
        musicArrayList.add(new Music("Blues", "Blues", "Jimmy Hendrix", "Voodoo Chile Blues", R.drawable.blues_album));
        musicArrayList.add(new Music("Blues", "Blues", "Jimmy Hendrix", "Mannish Boy", R.drawable.blues_album));
        musicArrayList.add(new Music("Blues", "Blues", "Jimmy Hendrix", "Once I Had A Woman", R.drawable.blues_album));
        musicArrayList.add(new Music("Blues", "Blues", "Jimmy Hendrix", "Bleeding Heart", R.drawable.blues_album));
        musicArrayList.add(new Music("Blues", "Blues", "Jimmy Hendrix", "Jelly 292", R.drawable.blues_album));
        musicArrayList.add(new Music("Blues", "Blues", "Jimmy Hendrix", "Electric Church Red House", R.drawable.blues_album));
        musicArrayList.add(new Music("Blues", "Blues", "Jimmy Hendrix", "Hear My Train A Comin' ", R.drawable.blues_album));
        musicArrayList.add(new Music("Classic", "5th Symphony", "Beethoven", "The 5th Symphony' ", R.drawable.beethoven_5));
        musicArrayList.add(new Music("Rock", "Californication", "Red Hot Chili Peppers", "Around the World", R.drawable.californication_album));
        musicArrayList.add(new Music("Rock", "Californication", "Red Hot Chili Peppers", "Parallel Universe", R.drawable.californication_album));
        musicArrayList.add(new Music("Rock", "Californication", "Red Hot Chili Peppers", "Scar Tissue", R.drawable.californication_album));
        musicArrayList.add(new Music("Rock", "Californication", "Red Hot Chili Peppers", "Otherside", R.drawable.californication_album));
        musicArrayList.add(new Music("Rock", "Californication", "Red Hot Chili Peppers", "Get on Top", R.drawable.californication_album));
        musicArrayList.add(new Music("Rock", "Californication", "Red Hot Chili Peppers", "Californication", R.drawable.californication_album));
        musicArrayList.add(new Music("Rock", "Californication", "Red Hot Chili Peppers", "Easily", R.drawable.californication_album));
        musicArrayList.add(new Music("Rock", "Californication", "Red Hot Chili Peppers", "Porcelain", R.drawable.californication_album));
        musicArrayList.add(new Music("Rock", "Californication", "Red Hot Chili Peppers", "Emit Remmus", R.drawable.californication_album));
        musicArrayList.add(new Music("Rock", "Californication", "Red Hot Chili Peppers", "I Like Dirt", R.drawable.californication_album));
        musicArrayList.add(new Music("Rock", "Californication", "Red Hot Chili Peppers", "This Velvet Glove", R.drawable.californication_album));
        musicArrayList.add(new Music("Rock", "Californication", "Red Hot Chili Peppers", "Savior", R.drawable.californication_album));
        musicArrayList.add(new Music("Rock", "Californication", "Red Hot Chili Peppers", "Purple Stain", R.drawable.californication_album));
        musicArrayList.add(new Music("Rock", "Californication", "Red Hot Chili Peppers", "Right on Time", R.drawable.californication_album));
        musicArrayList.add(new Music("Rock", "Californication", "Red Hot Chili Peppers", "Road Trippin", R.drawable.californication_album));

        // Get the results of genre
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if (bundle != null) {
            String mGenre1 = bundle.getString("Genre");
            System.out.println(mGenre1);
            Log.i("TitleActivity", "Genre: " + mGenre1);
            if (mGenre1 != null) {
                int musicSize = musicArrayList.size();
                ArrayList<Music> genreList = new ArrayList<Music>();
                for (int i = 0; i < musicSize; i++) {
                    if (musicArrayList.get(i).getGenre().equals(mGenre1)) {
                        genreList.add(musicArrayList.get(i));
                        System.out.println(genreList);
                    }
                    System.out.println(musicArrayList.get(i).getGenre());
                }
                musicArrayList.clear();
                musicArrayList.addAll(genreList);
                System.out.println(genreList);
            }
        }
        final MusicListAdapter adapter = new MusicListAdapter(this, musicArrayList);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                String mGenre = musicArrayList.get(position).getGenre();
                String mRecord = musicArrayList.get(position).getRecord();
                String mArtist= musicArrayList.get(position).getArtist();
                String mTitle = musicArrayList.get(position).getTitle();
                int mImgRecord = musicArrayList.get(position).getImageResourceId();
                Intent intent = new Intent(TitleActivity.this, MusicPlay.class);
                intent.putExtra("Genre", mGenre);
                intent.putExtra("Record", mRecord);
                intent.putExtra("Artist", mArtist);
                intent.putExtra("Title", mTitle);
                intent.putExtra("Image", mImgRecord);
                startActivity(intent);
            }
        });

        editText = (EditText) findViewById(R.id.search);

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //Search or Filter
                MusicListAdapter adapter1;
                adapter1 = adapter;
                String single = editText.getText().toString().toLowerCase(Locale.getDefault());
                adapter1.titleFilter(single);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }

        });
    }
}
