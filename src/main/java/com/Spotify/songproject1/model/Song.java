package com.Spotify.songproject1.model;

public class Song {
    private int song_Id;
    private String song_Name;
    private String artist_Name;
    private String album_Name;
    private String genre;
    private float song_Duration;

    public Song(int song_Id, String song_Name, String artist_Name, String album_Name, String genre, float song_Duration) {
        this.song_Id = song_Id;
        this.song_Name = song_Name;
        this.artist_Name = artist_Name;
        this.album_Name = album_Name;
        this.genre = genre;
        this.song_Duration = song_Duration;
    }

    public Song(String song_Name, String artist_Name, String album_Name, String genre, float song_Duration) {
        this.song_Name = song_Name;
        this.artist_Name = artist_Name;
        this.album_Name = album_Name;
        this.genre = genre;
        this.song_Duration = song_Duration;
    }

    public int getSong_Id() {
        return song_Id;
    }

    public String getSong_Name() {
        return song_Name;
    }

    public String getArtist_Name() {
        return artist_Name;
    }

    public String getAlbum_Name() {
        return album_Name;
    }

    public String getGenre() {
        return genre;
    }

    public float getSong_Duration() {
        return song_Duration;
    }

    @Override
    public String toString() {
        return String.format("%10s\t%30s\t%30s\t%20s\t%20s\t%20s", song_Id,song_Name,artist_Name,album_Name,genre,song_Duration+"\n");
    }
}
