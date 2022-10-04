package com.Spotify.songproject1.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Hashtable;

public class PlaylistDAO {
   public boolean createPlaylist(String playlistName) throws SQLException {
        PreparedStatement insertPlaylist=SongConnection.getConnection()
                .prepareStatement("insert into playlist(playlist_Name) values(?)");
        insertPlaylist.setString(1,playlistName);
        int result=insertPlaylist.executeUpdate();
        return result>0?true:false;
    }
    public Hashtable<String,Integer> viewPlayist() throws SQLException {
        Hashtable<String,Integer> playlist=new Hashtable<>();
        PreparedStatement selectPlaylist=SongConnection.getConnection()
                .prepareStatement("select * from playlist");
        ResultSet resultSet= selectPlaylist.executeQuery();
        while(resultSet.next()){
            playlist.put(resultSet.getString(2),resultSet.getInt(1));
        }return playlist;
    }

}
