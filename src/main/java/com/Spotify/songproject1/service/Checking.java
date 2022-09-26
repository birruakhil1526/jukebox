package com.Spotify.songproject1.service;

import com.Spotify.songproject1.DAO.SongDAO;
import com.Spotify.songproject1.model.Song;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

public class Checking {
    SongDAO songDAO=new SongDAO();//
    public void addSongs(Song song) throws SQLException {
        boolean result= songDAO.insertSong(song);
        if(result){
            System.out.println("Song details added successfully");
        }else {
            System.out.println("details are already added");
        }
    }
    public void display() throws SQLException {
        ArrayList<Song> songList=songDAO.selectSongs();
        Iterator<Song> songIterator=songList.listIterator();
        while (songIterator.hasNext()){
            System.out.println(songIterator.next());
        }
    }

}
