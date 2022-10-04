package com.Spotify.songproject1.service;

import com.Spotify.songproject1.DAO.PlaylistDAO;
import com.Spotify.songproject1.model.Song;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Set;

public class PlaylistCheck {
    PlaylistDAO playlistDAO=new PlaylistDAO();
    public boolean addPlaylist(Hashtable<String,Integer> playlist,String playListName) throws Exception {
        boolean result =false;
        if(!playlist.isEmpty()&&playListName!=null){
        boolean playlistisPresent=playlist.containsKey(playListName);
        if(playlistisPresent==false){
            playlistDAO.createPlaylist(playListName);
            result=true;
        }} else {
            throw new Exception("please provide all details");
        }return result;
    }
     public Hashtable<String,Integer> getallPlaylists() throws SQLException {
        Hashtable<String,Integer> result=playlistDAO.viewPlayist();
        return result;
     }
     public Set<String> playlistDisplay() throws SQLException {
        Set<String> playlistItems=getallPlaylists().keySet();
        return playlistItems;
     }

}
