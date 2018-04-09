package com.example.android.mymusicplayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);


        // Find the View that shows the numbers category
        TextView genre = (TextView) findViewById(R.id.genre);
        TextView title = (TextView) findViewById(R.id.title);

        // Set a click listener on that View
        genre.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View v) {
                Intent numbersIntent = new Intent(MainActivity.this, GenreActivity.class);
                startActivity(numbersIntent);
            }
        });

        title.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View v) {
                Intent colorsIntent = new Intent(MainActivity.this, TitleActivity.class);
                startActivity(colorsIntent);
            }
        });
    }
}
