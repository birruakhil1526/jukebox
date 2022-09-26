package com.Spotify.songproject1.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SongConnection {
    public static Connection getConnection() throws SQLException {
        Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/jukebox","root","Bunny@3681");
        if(connection.isClosed()==false){
            System.out.println("You are into jukebox database");
        }return connection;
    }
}
