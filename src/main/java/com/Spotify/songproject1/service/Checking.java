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
    private boolean checkSong(String songName,ArrayList<Song> songArrayList) {
        boolean result =false;
        for(Song song:songArrayList){
            if(song.getSong_Name().equalsIgnoreCase(songName)){
                result=true;
                break;
            }
        }return result;
    }
     public ArrayList<Song> getAllSongs() throws SQLException {
        ArrayList<Song> result=songDAO.selectSongs();
        return result;
    }
    public ArrayList<Song> getSongByAlbumName(String albumName, ArrayList<Song> songArrayList) {
        ArrayList<Song> filterByAlbumList=null;
        if(songArrayList.isEmpty()==false&&albumName!=null){
            filterByAlbumList=new ArrayList<>();
            for(Song song:songArrayList){
                if(song.getAlbum_Name().equalsIgnoreCase(albumName)){
                    filterByAlbumList.add(song);
                }
            }
        }return filterByAlbumList;

    }
    public ArrayList<Song> getSongByArtistName(String artistName,ArrayList<Song> songArrayList)  {
        ArrayList<Song> filterByArtistName=null;
        if(songArrayList.isEmpty()==false&&artistName!=null){
            filterByArtistName=new ArrayList<>();
            for(Song song:songArrayList){
                if(song.getArtist_Name().equalsIgnoreCase(artistName)){
                    filterByArtistName.add(song);
                }
            }
        }return filterByArtistName;
    }
    public ArrayList<Song> getSongByGenre(String genre,ArrayList<Song> songArrayList){
        ArrayList<Song> filterByGenre=null;
        if(songArrayList.isEmpty()==false&&genre!=null){
            filterByGenre=new ArrayList<>();
            for(Song song:songArrayList){
                if(song.getGenre().equalsIgnoreCase(genre)){
                    filterByGenre.add(song);
                }
            }
        }return filterByGenre;
    }
    public ArrayList<Song> getSongBySongName(String songName,ArrayList<Song> songArrayList){
        ArrayList<Song> filterByName=null;
        if(songArrayList.isEmpty()==false&&songName!=null){
            filterByName=new ArrayList<>();
            for(Song song:songArrayList){
                if(song.getSong_Name().equalsIgnoreCase(songName)){
                    filterByName.add(song);
                }
            }
        }return filterByName;
    }

}
