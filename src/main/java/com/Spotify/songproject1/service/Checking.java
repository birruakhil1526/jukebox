package com.Spotify.songproject1.service;

import com.Spotify.songproject1.DAO.SongDAO;
import com.Spotify.songproject1.model.Song;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

public class Checking {
    SongDAO songDAO=new SongDAO();//
    public boolean  addSongs(Song song) throws SQLException {
        boolean result=false;
        ArrayList<Song> songList=new ArrayList<>();
        boolean checksong=checkSong(song.getSong_Name(),songList);
        if(checksong==false) {
            songDAO.insertSong(song);
            result=true;
        }return result;
    }
    public void display() throws SQLException {
        ArrayList<Song> songList=songDAO.selectSongs();
        System.out.format("%10s %30s    %30s    %20s    %15s    %25s" ,"SONG ID","SONG NAME","ARTIST NAME","ALBUM NAME","GENRE","SONG DURATION" );
        System.out.println();
        for(Song song:songList){
           System.out.println(song);
       }
    }
    private boolean checkSong(String songName,ArrayList<Song> songArrayList) throws SQLException {
        boolean result =false;
        for(Song song:songArrayList){
            if(song.getSong_Name().equalsIgnoreCase(songName)){
                result=true;
                break;
            }
        }return result;
    }

}
