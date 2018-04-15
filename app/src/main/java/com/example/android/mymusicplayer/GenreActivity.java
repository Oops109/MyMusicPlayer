package com.example.android.mymusicplayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListAdapter;

import java.util.ArrayList;

/**
 * Created by fanny on 31/03/2018.
 */

public class GenreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        android.support.v7.app.ActionBar actionBar =getSupportActionBar();
        assert actionBar != null;
        Log.i("GenreActivity", "ab value: " + actionBar);
        actionBar.setDisplayHomeAsUpEnabled(true);

        setContentView(R.layout.grid_list);
        final ArrayList<Genre> genreList = new ArrayList<Genre>();
        genreList.add(new Genre("Jazz"));
        genreList.add(new Genre("Blues"));
        genreList.add(new Genre("Rock"));
        genreList.add(new Genre("Classic"));
        GenreListAdapter itemsAdapter = new GenreListAdapter(this, genreList);
        final GridView listView = (GridView) findViewById(R.id.gridlist);
        listView.setAdapter((ListAdapter) itemsAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                String mGenre = genreList.get(position).getGenre();
                Intent intent = new Intent(GenreActivity.this, TitleActivity.class);
                intent.putExtra("Genre", mGenre);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        finish();
    }


}

