package com.Spotify.songproject1.Main;

import com.Spotify.songproject1.service.Checking;
import com.Spotify.songproject1.model.Song;

import java.sql.SQLException;//

public class MainMethod {
    public static void main(String[] args) {
        Checking checking=new Checking();
        Song song=new Song(115,"Golden Hour","JVKE","Golden Hour","melody",4.22f);
        try {
           //checking.addSongs(song);
           checking.display();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
