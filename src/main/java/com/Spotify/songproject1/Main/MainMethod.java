package com.Spotify.songproject1.Main;

import com.Spotify.songproject1.service.Checking;
import com.Spotify.songproject1.model.Song;

import java.sql.SQLException;//
import java.util.ArrayList;

public class MainMethod {
    public static void main(String[] args) {
        Checking checking=new Checking();
        Song song=new Song(115,"Golden Hour","JVKE","Golden Hour","melody",4.22f);
        try {
           //checking.addSongs(song);
            ArrayList<Song> songs=checking.getAllSongs();
           checking.display();
            System.out.println("get songs by name");
            System.out.println(checking.getSongBySongName("Golden Hour",songs)+"\n");
            System.out.println("get song by album name");
            System.out.println(checking.getSongByAlbumName("rrr",songs)+"\n");
            System.out.println("get song by artist name");
            System.out.println(checking.getSongByArtistName("jvke",songs)+"\n");
            System.out.println("get song by genre");
            System.out.println(checking.getSongByGenre("melody",songs)+"\n");
            System.out.println();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
