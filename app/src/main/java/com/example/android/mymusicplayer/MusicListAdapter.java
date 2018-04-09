package com.example.android.mymusicplayer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by fanny on 31/03/2018.
 */

public class MusicListAdapter extends BaseAdapter {

    Context cont;
    LayoutInflater layinf;
    List<Music> musiclist;
    ArrayList<Music> musicarray;

    public MusicListAdapter(Context con, List<Music> musics){
        cont = con;
        musiclist = musics;
        this.layinf = LayoutInflater.from(cont);
        this.musicarray = new ArrayList<Music>();
        this.musicarray.addAll(musics);
    }


    public class ViewHolder {
        TextView genre;
        TextView record;
        TextView artist;
        TextView title;
        // Find the ImageView in the list_item.xml layout with the ID list_item_icon
        ImageView imgRecord;
    }

    @Override
    public int getCount() {
        return musiclist.size();
    }

    @Override
    public Music getItem(int position) {
        return musiclist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        if (convertView == null){
            holder = new ViewHolder();
            convertView = layinf.inflate(R.layout.music_item, null);
            holder.genre= (TextView)convertView.findViewById(R.id.genre_text);
            holder.record= (TextView)convertView.findViewById(R.id.record_text);
            holder.artist= (TextView)convertView.findViewById(R.id.artist_text);
            holder.title= (TextView)convertView.findViewById(R.id.title_text);
            holder.imgRecord= (ImageView) convertView.findViewById(R.id.image_record);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder)convertView.getTag();
        }
        holder.genre.setText(musiclist.get(position).getGenre());
        holder.record.setText(musiclist.get(position).getRecord());
        holder.artist.setText(musiclist.get(position).getArtist());
        holder.title.setText(musiclist.get(position).getTitle());
        // Find the ImageView in the list_item.xml layout with the ID list_item_icon
        holder.imgRecord.setImageResource(musiclist.get(position).getImageResourceId());

        return convertView;
    }

    public void titleFilter(String name){
        name = name.toLowerCase(Locale.getDefault());
        musiclist.clear();
        if (name.length() == 0){
            musiclist.addAll(musicarray);
        } else {
            for (Music ml : musicarray){
                if (ml.getTitle().toLowerCase(Locale.getDefault()).contains(name)){
                    musiclist.add(ml);
                }
            }
        }
        notifyDataSetChanged();
    }
}
