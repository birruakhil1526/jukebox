package com.Spotify.songproject1.DAO;

import com.Spotify.songproject1.model.Song;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SongDAO {
    public boolean insertSong(Song song) throws SQLException {
        PreparedStatement insertStatement=SongConnection.getConnection()
                .prepareStatement("insert into songs values(?,?,?,?,?,?)");
        insertStatement.setInt(1,song.getSong_Id());
        insertStatement.setString(2, song.getSong_Name());
        insertStatement.setString(3,song.getArtist_Name());
        insertStatement.setString(4,song.getAlbum_Name());
        insertStatement.setString(5,song.getGenre());
        insertStatement.setFloat(6,song.getSong_Duration());
        int result=insertStatement.executeUpdate();
        return result>0?true:false;
    }
    public ArrayList<Song> selectSongs() throws SQLException {
        ArrayList<Song> songArrayList=null;//
        PreparedStatement selectSong=SongConnection.getConnection()
                .prepareStatement("select * from songs");
        ResultSet resultSet=selectSong.executeQuery();
        if(resultSet.isBeforeFirst()){
            songArrayList=new ArrayList<>();
            while(resultSet.next()){
                songArrayList.add(new Song(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4)
                ,resultSet.getString(5),resultSet.getFloat(6)));
            }
        }return songArrayList;
    }

}
