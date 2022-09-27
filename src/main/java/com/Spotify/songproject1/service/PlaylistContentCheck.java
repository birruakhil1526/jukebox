package com.Spotify.songproject1.service;

import com.Spotify.songproject1.DAO.PlayListContentDAO;
import com.Spotify.songproject1.model.Song;

import java.util.ArrayList;
import java.util.Hashtable;

public class PlaylistContentCheck {
    PlayListContentDAO playListContentDAO=new PlayListContentDAO();
    public boolean addSongtoPlaylist(ArrayList<Song> songlist, Hashtable<String,Integer> playlist, String songName, String playlistName) throws Exception {
        boolean result=false;
        if(songName!=null&& playlistName!=null){
            int playlistId=playlist.get(playlistName);
            int songId;
            for( Song song:songlist){
                songId=song.getSong_Id();
               if(songId==0){
                   throw new Exception("Song id is not present");
               } else if (playlistId==0) {
                   throw new Exception("Playlist id is not present");
               }else{
                   playListContentDAO.createPlaylistContent(playlistId,songId);
                   result=true;
               }
            }
        }return result;
    }
    public boolean addAlbumtoPlaylist(ArrayList<Song> songArrayList,Hashtable<String,Integer> playlist,String albumName,String playlistName) throws Exception {
        boolean result=false;
        if(albumName!=null&&playlistName!=null){
            int playlistId=playlist.get(playlistName);
            ArrayList<Integer> songIdList=new ArrayList<>();
            for(Song song:songArrayList){
                songIdList.add(song.getSong_Id());
                if(songIdList.isEmpty()){
                    throw new Exception("Album is empty");
                } else if (playlistId==0) {
                    throw new Exception("Playlist is empty");
                }else {
                    for(int id:songIdList){
                        playListContentDAO.createPlaylistContent(playlistId,id);
                        result=true;
                    }
                }
            }
        }return result;
    }
    public ArrayList<Song> playlistContent(String playlistName,Hashtable<String,Integer> playlist,ArrayList<Song> songArrayList) throws Exception {
        ArrayList<Song> myplaylist=new ArrayList<>();
        if(playlistName!=null){
            int playlistId=playlist.get(playlistName);
            if(playlistId==0){
                throw new Exception("Playlist is empty");
            }else{
                ArrayList<Integer> songidList=playListContentDAO.viewPlaylistContent(playlistId);
                for(int id:songidList){
                    for(Song song:songArrayList){
                        if(song.getSong_Id()==id){
                            myplaylist.add(song);
                        }
                    }
                }
            }
        }return myplaylist;
    }
}
