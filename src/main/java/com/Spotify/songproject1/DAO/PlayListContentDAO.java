package com.Spotify.songproject1.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PlayListContentDAO {
    public boolean createPlaylistContent(int playlistId,int songId) throws SQLException {
        PreparedStatement insertPlaylistContent=SongConnection.getConnection()
                .prepareStatement("insert into playlistcontent values(?,?)");
        insertPlaylistContent.setInt(1,playlistId);
        insertPlaylistContent.setInt(2,songId);
        int result=insertPlaylistContent.executeUpdate();
        return result>0?true:false;
    }
    public ArrayList<Integer> viewPlaylistContent(int playlistId) throws SQLException {
        ArrayList<Integer> playlistContent=null;
        PreparedStatement selectPlaylistContent=SongConnection.getConnection()
                .prepareStatement("select * from playlistcontent where playlist_Id=?");
        selectPlaylistContent.setInt(1,playlistId);
        ResultSet resultSet=selectPlaylistContent.executeQuery();
        if(resultSet.isBeforeFirst()){
            playlistContent=new ArrayList<>();
            while(resultSet.next()){
                playlistContent.add(resultSet.getInt(2));
            }
        }return playlistContent;
    }

}
