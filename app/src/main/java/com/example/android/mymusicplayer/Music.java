package com.example.android.mymusicplayer;

/**
 + * {@link Music}the music the users wants to play.
 + */

public class Music {
    // String value for the music genre
    private String mGenreMusic;

    // String value for the music record
    private String mRecordMusic;

    // String value for the music artist
    private String mArtistMusic;

    // String value for the Title of the music play
    private String mTitleMusic;

    // Drawable resource ID
     private int mImageResourceId;
    /**


     +     * Create a new Music object.
     +     *
     +     * @param genreMusic is the genre of the music play
     +     * @param recordMusic is the name of the record on witch you find the music
     +     * @param artistMusic is the name of the artist of the music
     +     * @param ImageRessourceId image related
     +     */
    public Music(String genreMusic, String recordMusic, String artistMusic, String titleMusic, int imageResourceId ) {
        mGenreMusic = genreMusic;
        mRecordMusic= recordMusic;
        mArtistMusic = artistMusic;
        mTitleMusic = titleMusic;
        mImageResourceId = imageResourceId;
    }


    /**
     * get  genre value
     * get record value
     * get artist value
     * get title value
     * get image value
     * @return current genre in Music class
     * @return current record in Music class
     * @return current artist in Music class
     * @return current title in Music class
     * @return current image in Music class */
    public String getGenre () {
        return mGenreMusic;
    }
    public String getRecord () {
        return mRecordMusic;
    }
    public String getArtist () {
        return mArtistMusic;
    }
    public String getTitle () {
        return mTitleMusic;
    }
    public int getImageResourceId () {
        return mImageResourceId;
    }

        public Music[] newArray(int size) {
            return new Music[size];

        }

}
