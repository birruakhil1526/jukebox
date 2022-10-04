package com.Spotify.songproject1.service;

import com.Spotify.songproject1.DAO.SongDAO;
import com.Spotify.songproject1.model.Song;

import java.sql.SQLException;
import java.util.ArrayList;

public class Checking {
    SongDAO songDAO=new SongDAO();//
    public boolean  addSongs(Song song,ArrayList<Song> songList) throws Exception {
        boolean result=false;
        boolean checksong=checkSong(song.getSong_Name(), songList);
        if(checksong==false) {
            songDAO.insertSong(song);
            result=true;
        }return result;
    }
    public void display() throws SQLException {
        ArrayList<Song> songList=songDAO.selectSongs();
        System.out.format("%10s %30s    %30s    %20s    %15s    %25s" ,"SONG ID","SONG NAME","ARTIST NAME","ALBUM NAME","GENRE","SONG DURATION" +"\n");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println();
        for(Song song:songList){
            System.out.println(song);
       }
    }
    private boolean checkSong(String songName,ArrayList<Song> songArrayList) throws Exception {
        boolean result =false;
        if(songName!=null&&!songArrayList.isEmpty()){
        for(Song song:songArrayList){
            if(song.getSong_Name().equalsIgnoreCase(songName)){
                result=true;
                break;
            }
        }}else {
            throw new Exception("please provide all details");
        }return result;
    }
     public ArrayList<Song> getAllSongs() throws SQLException {
        ArrayList<Song> result=songDAO.selectSongs();
        return result;
    }
    public ArrayList<Song> getSongByAlbumName(String albumName, ArrayList<Song> songArrayList) throws Exception {
        ArrayList<Song> filterByAlbumList;
        if(!songArrayList.isEmpty() &&albumName!=null){
            filterByAlbumList=new ArrayList<>();
            for(Song song:songArrayList){
                if(song.getAlbum_Name().equalsIgnoreCase(albumName)){
                    filterByAlbumList.add(song);
                    break;
                }
            }
        }else {
            throw new Exception("please provide all details");
        }return filterByAlbumList;

    }
    public ArrayList<Song> getSongByArtistName(String artistName,ArrayList<Song> songArrayList) throws Exception {
        ArrayList<Song> filterByArtistName;
        if(!songArrayList.isEmpty() &&artistName!=null){
            filterByArtistName=new ArrayList<>();
            for(Song song:songArrayList){
                if(song.getArtist_Name().equalsIgnoreCase(artistName)){
                    filterByArtistName.add(song);
                }
            }
        }else {
            throw new Exception("please provide all details");
        }return filterByArtistName;
    }
    public ArrayList<Song> getSongByGenre(String genre,ArrayList<Song> songArrayList) throws Exception {
        ArrayList<Song> filterByGenre;
        if(songArrayList.isEmpty()==false&&genre!=null){
            filterByGenre=new ArrayList<>();
            for(Song song:songArrayList){
                if(song.getGenre().equalsIgnoreCase(genre)){
                    filterByGenre.add(song);
                }
            }
        }else {
            throw new Exception("please provide all details");
        }return filterByGenre;
    }
    public ArrayList<Song> getSongBySongName(String songName,ArrayList<Song> songArrayList) throws Exception {
        ArrayList<Song> filterByName;
        if(!songArrayList.isEmpty() &&songName!=null){
            filterByName=new ArrayList<>();
            for(Song song:songArrayList){
                if(song.getSong_Name().equalsIgnoreCase(songName)){
                    filterByName.add(song);
                }
            }
        }else {
            throw new Exception("please provide all details");
        }return filterByName;
    }

}
