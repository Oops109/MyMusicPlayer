package com.example.android.mymusicplayer;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by fanny on 31/03/2018.
 */

public class GenreListAdapter extends ArrayAdapter<Genre> {

    public GenreListAdapter(Activity context, ArrayList<Genre> genres) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, genres);
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.genre_item, parent, false);
        }

        Genre genreText= getItem(position);
        TextView genreTextView = (TextView) listItemView.findViewById(R.id.genre_text);
        genreTextView .setText(genreText.getGenre());
        return listItemView;
    }
}