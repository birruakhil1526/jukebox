package com.Spotify.songproject1.service;

import com.Spotify.songproject1.DAO.PlaylistDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Hashtable;

public class PlaylistCheck {
    PlaylistDAO playlistDAO=new PlaylistDAO();
    public boolean addPlaylist(Hashtable<String,Integer> playlist,String playListName) throws SQLException {
        boolean result =false;
        boolean playlistisPresent=playlist.containsKey(playListName);
        if(playlistisPresent==false){
            playlistDAO.createPlaylist(playListName);
            result=true;
        }return result;
    }
     public Hashtable<String,Integer> getallPlaylists() throws SQLException {
        Hashtable<String,Integer> result=playlistDAO.viewPlayist();
        return result;
     }

}
