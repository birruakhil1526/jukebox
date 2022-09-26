package com.Spotify.songproject1.Main;

import com.Spotify.songproject1.service.Checking;
import com.Spotify.songproject1.model.Song;

import java.sql.SQLException;//

public class MainMethod {
    public static void main(String[] args) {
        Checking checking=new Checking();
        Song song=new Song(112,"Priyathama nivachata kushalama","Balasubrahmanyam","YVM","melody",6.09f);
        try {
           // checking.addSongs(song);
            checking.display();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
