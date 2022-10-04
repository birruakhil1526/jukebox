package com.Spotify.songproject1.service;
import com.Spotify.songproject1.DAO.PlayListContentDAO;
import com.Spotify.songproject1.model.Song;
import java.util.ArrayList;
import java.util.Hashtable;

public class PlaylistContentCheck {
    PlayListContentDAO playListContentDAO=new PlayListContentDAO();
    public boolean addSongtoPlaylist(ArrayList<Song> songlist, Hashtable<String,Integer> playlist, String songName, String playlistName) throws Exception {
        boolean result;
        if(songName!=null&& playlistName!=null&&!songlist.isEmpty()&&!playlist.isEmpty()){
            int playlistId;
            int songId=0;
            for( Song song:songlist){
                if(song.getSong_Name().equalsIgnoreCase(songName)){
                       songId=song.getSong_Id();
                       break;
                }}
               if(songId==0){
                   throw new Exception("Song name is not present");
               } else if (!playlist.containsKey(playlistName)) {
                   throw new Exception("Playlist Name is not present");
               }else{
                   playlistId=playlist.get(playlistName);
                  result= playListContentDAO.createPlaylistContent(playlistId,songId);
               }
        }else {
            throw new Exception("please provide all details");
        }
        return result;
    }
    public boolean addAlbumtoPlaylist(ArrayList<Song> songArrayList,Hashtable<String,Integer> playlist,String albumName,String playlistName) throws Exception {
        boolean result=false;
        if(albumName!=null&&playlistName!=null&&!songArrayList.isEmpty()&&!playlist.isEmpty()){
            int playlistId;
            ArrayList<Integer> songIdList=new ArrayList<>();
            for(Song song:songArrayList){
                if(song.getAlbum_Name().equalsIgnoreCase(albumName)){
                      songIdList.add(song.getSong_Id());
                             break;
                }}
                if(songIdList.isEmpty()){
                    throw new Exception("Album is empty");
                } else if (!playlist.containsKey(playlistName)) {
                    throw new Exception("Playlist name is not present");
                }else {
                    playlistId=playlist.get(playlistName);
                    for(int id:songIdList){
                        result=playListContentDAO.createPlaylistContent(playlistId,id);
                    }
            }
        }else {
            throw new Exception("please provide all details");
        }return result;
    }
    public ArrayList<Song> playlistContent(String playlistName,Hashtable<String,Integer> playlist,ArrayList<Song> songArrayList) throws Exception {
        ArrayList<Song> myplaylist=null;
        ArrayList<Integer> songidList;
        if(playlistName!=null&&!playlist.isEmpty()&&!songArrayList.isEmpty()){
            int playlistId;
            if(!playlist.containsKey(playlistName)){
                throw new Exception("Playlist name is not present");
            }else{
                playlistId=playlist.get(playlistName);
                songidList=playListContentDAO.viewPlaylistContent(playlistId);
            if(!(songidList==null)){
                myplaylist=new ArrayList<>();
                for(int id:songidList){
                    for(Song song:songArrayList){
                        if(song.getSong_Id()==id){
                            myplaylist.add(song);
                        }
                    }
            }
            }else{
                throw new Exception("No song present");
            }}
        }else {
            throw new Exception("please provide all details");
        }return myplaylist;
    }
}
