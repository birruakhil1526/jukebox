package com.Spotify.songproject1.Main;
import com.Spotify.songproject1.service.Checking;
import com.Spotify.songproject1.model.Song;
import com.Spotify.songproject1.service.PlaylistCheck;
import com.Spotify.songproject1.service.PlaylistContentCheck;
import com.Spotify.songproject1.service.playercheck;
import com.sun.jdi.request.DuplicateRequestException;

import javax.sound.sampled.Clip;
import java.sql.SQLException;//
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.SQLOutput;
import java.util.*;

public class MainMethod {
    public static void playerdisplay(){
        System.out.println("             PLAYER MENU ");
        System.out.println("------------------------------------------");
        System.out.println(" 1. Pause \n 2. Resume \n 3. Restart \n 4. Stop \n 5. Forward \n 6. Backward \n");
    }
    public static void alldisplay(){
        System.out.format("%10s %30s    %30s    %20s    %15s    %25s" ,"SONG ID","SONG NAME","ARTIST NAME","ALBUM NAME","GENRE","SONG DURATION" +"\n");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------");
    }
    public static void menudisplay(){
        System.out.println("           SPOTIFY MAIN MENU ");
        System.out.println("-------------------------------------------");
        System.out.println(" 1. Songs \n 2. Playlist \n 3. Player \n 4. Exit \n");
    }
    public static void songsMenu(){
        System.out.println("               SONGS MENU ");
        System.out.println("--------------------------------------------");
        System.out.println(" 1. Add songs \n 2. Search song by Name \n 3. Search song by Artist \n 4. Search song by Genre \n 5. Search song by Album \n 6. Main Menu \n 7. Exit \n");
    }
    public static void playlistMenu(){
        System.out.println("             PLAYLIST MENU ");
        System.out.println("---------------------------------------------");
        System.out.println(" 1. My playlist \n 2. Create playlist \n 3. Add song to playlist \n 4. Display playlist content \n 5. Add album to playlist \n 6. Main Menu \n 7. Exit \n");
    }
    public static void main(String[] args) {
        Checking checking=new Checking();
        PlaylistCheck playlistCheck=new PlaylistCheck();
        playercheck playercheck=new playercheck();
        PlaylistContentCheck playlistContentCheck=new PlaylistContentCheck();
        char selection;
        char selection1;
        char playselect;
        Song song=new Song("Dandelions","Ruth B","Safe heaven","melody",3.53f);
        System.out.println("");
        try {
            ArrayList<Song> songlist;
            Hashtable<String,Integer> playlist;
            Set<String> playlistItems;
            songlist=checking.getAllSongs();
             do{
            checking.display();
            menudisplay();
            System.out.println(" Please select any option :\n");
            Scanner sc=new Scanner(System.in);
            int option=sc.nextInt();
            switch(option){
                case 1:
                    do{
                    songsMenu();
                    System.out.println("Please select any option :");
                    int choice1=sc.nextInt();
                    switch(choice1){
                        case 1:
                            sc.nextLine();
                            System.out.println("Upload song");
                            System.out.println("Enter the song name \n");
                            String songName=sc.nextLine();
                            System.out.println("Enter the artist name \n");
                            String artistName=sc.nextLine();
                            System.out.println("Enter the album name \n");
                            String albumName=sc.nextLine();
                            System.out.println("Enter the Genre \n");
                            String genre=sc.nextLine();
                            System.out.println("Enter the song duration \n");
                            float songDuration=sc.nextFloat();
                            Song song1=new Song(songName,artistName,albumName,genre,songDuration);
                            checking.addSongs(song1,songlist);
                            checking.display();
                            break;
                        case 2:
                            sc.nextLine();
                            System.out.println("Search song by song name");
                            System.out.println("Enter the song name \n");
                            String searchSongName=sc.nextLine();
                            ArrayList<Song> searchBysongName=checking.getSongBySongName(searchSongName,songlist);
                            if(!searchBysongName.isEmpty()) {
                                alldisplay();
                                for (Song name : searchBysongName)
                                    System.out.println(name);
                            }else{
                                System.out.println("Invalid song name");
                            }
                            break;
                        case 3:
                            sc.nextLine();
                            System.out.println("Search song by Artist");
                            System.out.println("Enter the artist name \n");
                            String searchArtistName=sc.nextLine();
                            ArrayList<Song> searchsongByArtistName=checking.getSongByArtistName(searchArtistName,songlist);
                            if(!searchsongByArtistName.isEmpty()) {
                                alldisplay();
                                for (Song artistsong : searchsongByArtistName)
                                    System.out.println(artistsong);
                            }else{
                                System.out.println("invalid artist name");
                            }
                            break;
                        case 4:
                            sc.nextLine();
                            System.out.println("Search song by Genre");
                            System.out.println("Enter the Genre \n");
                            String searchGenre=sc.nextLine();
                            ArrayList<Song> searchSongByGenre=checking.getSongByGenre(searchGenre,songlist);
                            if(!searchSongByGenre.isEmpty()) {
                                alldisplay();
                                for (Song genresong : searchSongByGenre)
                                    System.out.println(genresong);
                            }else{
                                System.out.println("invalid genre name");
                            }
                            break;
                        case 5:
                            sc.nextLine();
                            System.out.println("Search song by Album");
                            System.out.println("Enter the Album \n");
                            String searchAlbum=sc.nextLine();
                            ArrayList<Song> searchSongByAlbum=checking.getSongByAlbumName(searchAlbum,songlist);
                            if(!searchSongByAlbum.isEmpty()) {
                                alldisplay();
                                for (Song album : searchSongByAlbum)
                                    System.out.println(album);
                            }else{
                                System.out.println("invalid album name");
                            }
                            break;
                        case 6:
                            System.out.println(" Returning to Spotify menu");
                            break;
                        case 7:
                            System.exit(0);
                            break;
                        default:
                            System.out.println(" please enter the correct input");
                            break;
                    }
                        System.out.println(" If you want to return to songs menu press 'y' ");
                        selection1=sc.next().charAt(0);
                    }while(selection1=='y');
                    break;
                case 2:
                    char exit1;
                    do {
                        songlist=checking.getAllSongs();
                        playlist=playlistCheck.getallPlaylists();
                        playlistMenu();
                        System.out.println(" Please select any option :");
                        int option2 = sc.nextInt();
                        switch (option2) {
                            case 1:
                                playlistItems =playlistCheck.playlistDisplay();
                                System.out.println(playlistItems);
                                break;
                            case 2:
                                sc.nextLine();
                                System.out.println(" Enter the playlist Name ");
                                String playlistName = sc.nextLine();

                                boolean status = playlistCheck.addPlaylist(playlist, playlistName);
                                if (status) {
                                    System.out.println(playlistName + " -Playlist is added");
                                }else{
                                    System.out.println("Playlist already exists");
                                }
                                break;
                            case 3:
                                sc.nextLine();
                                System.out.println(" Enter the playlist name");
                                String playlistname = sc.nextLine();
                                System.out.println(" Enter the song name");
                                String songname = sc.nextLine();
                                boolean playlistStatus = playlistContentCheck.addSongtoPlaylist(songlist,playlist,songname,playlistname);
                                if (playlistStatus) {
                                    System.out.println(songname + " song added to playlist- " + playlistname);
                                }else{
                                    System.out.println("song name/playlist is not present");
                                }
                                break;
                            case 5:
                                sc.nextLine();
                                System.out.println(" Enter the album name");
                                String albumname = sc.nextLine();
                                System.out.println(" Enter the playlist name");
                                String albumplaylistname = sc.nextLine();
                                boolean albumStatus = playlistContentCheck.addAlbumtoPlaylist(songlist, playlist, albumname, albumplaylistname);
                                if (albumStatus) {
                                    System.out.println(albumname + " album is added to playlist- " + albumplaylistname);
                                }else{
                                    System.out.println("album/playlist is not present");
                                }
                                break;
                            case 4:
                                sc.nextLine();
                                System.out.println(" Enter the playlist to view");
                                String displayPlaylist = sc.nextLine();
                                ArrayList<Song> songsinPlaylist = playlistContentCheck.playlistContent(displayPlaylist, playlist, songlist);
                                if(!(songsinPlaylist==null)) {
                                    alldisplay();
                                    for (Song playlistsong : songsinPlaylist)
                                        System.out.println(playlistsong);
                                }
                                else{
                                    System.out.println("sd");
                                }
                            case 6:
                                System.out.println(" Returning to Spotify menu");
                                break;
                            case 7:
                                System.exit(0);
                                break;
                            default:
                                System.out.println(" please enter the correct input");
                        }
                        System.out.println(" If you want to return to playlist menu press 'y' ");
                        playselect=sc.next().charAt(0);
                    }while(playselect=='y');
                    break;
                case 3:
                    do {
                        sc.nextLine();
                        char exit='y' ;
                        int playerscan;
                        System.out.println("Please enter the song you want to play");
                        String playsong = sc.nextLine();
                        for (Song song2 : songlist) {
                            if (playsong.equalsIgnoreCase(song2.getSong_Name())) {
                                playerscan = song2.getSong_Id();
                                playercheck.player(playerscan);
                                playercheck.play();
                                System.out.println("[ NOW PLAYING-- "+song2.getSong_Name()+" ]"+"\n");
                                do {
                                    checking.display();
                                    playerdisplay();
                                    int playerChoice = sc.nextInt();
                                    switch (playerChoice) {
                                        case 1:
                                            playercheck.Pause();
                                            break;
                                        case 2:
                                            playercheck.play();
                                            System.out.println("[ NOW PLAYING-- "+song2.getSong_Name()+" ]"+"\n");
                                            break;
                                        case 3:
                                            playercheck.Restart(playerscan);
                                            System.out.println("[ NOW PLAYING-- "+song2.getSong_Name()+" ]"+"\n");
                                            break;
                                        case 4:
                                            System.out.println("if you want to continue to play press 'y'");
                                            exit = sc.next().charAt(0);
                                            playercheck.stop();
                                            break;
                                        case 5:
                                            System.out.println("[ NOW PLAYING-- "+song2.getSong_Name()+" ]"+"\n");
                                            System.out.println("Forwarded by 5-secs");
                                            playercheck.forward();
                                            break;
                                        case 6:
                                            System.out.println("[ NOW PLAYING-- "+song2.getSong_Name()+" ]"+"\n");
                                            System.out.println("Backward by 5-secs");
                                            playercheck.backward();
                                            break;
                                        default:
                                            System.out.println("please give correct input");
                                            break;
                                    }
                                } while (exit=='y');
                            }
                        }
                        System.out.println("If you want to play another song enter 'y'");
                        exit1=sc.next().charAt(0);
                    }while(exit1=='y');
                            break;
                case 4:
                    System.out.println(" Please give any feedback");
                    sc.next();
                    String feedback=sc.nextLine().trim();
                    System.out.println(feedback);
                    System.out.print(" Thank you for the feedback");
                    System.exit(0);
                    break;
                default:
                    System.out.println(" please enter the correct input");
            }
                 System.out.println(" If you want to return to Spotify menu press y");
                 selection=sc.next().charAt(0);
             }while(selection=='y');
        }
        catch(SQLIntegrityConstraintViolationException e){
            System.out.println("Song already present");
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        catch(InputMismatchException e){
                System.out.println("Please enter correct input");
            }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
