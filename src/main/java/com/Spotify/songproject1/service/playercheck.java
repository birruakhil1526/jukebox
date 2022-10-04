package com.Spotify.songproject1.service;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class playercheck {
    Clip clip;
    long currentFrame;
    public void player(int id) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
    AudioInputStream audioInputStream= AudioSystem.getAudioInputStream(new File("src/main/resources/" + id + ".wav"));
    clip=AudioSystem.getClip();
    clip.open(audioInputStream);
    clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    public void playerreset(int id) throws LineUnavailableException, IOException, UnsupportedAudioFileException {
        AudioInputStream audioInputStream= AudioSystem.getAudioInputStream(new File("src/main/resources/" + id + ".wav"));
        clip.open(audioInputStream);
        clip.loop(Clip.LOOP_CONTINUOUSLY);

    }
    public void Pause(){
        currentFrame=clip.getMicrosecondLength();
        clip.stop();
        System.out.println("Paused");
    }
    public void Resume(int id) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        clip.close();
        playerreset( id);
        clip.setMicrosecondPosition(currentFrame);
    }
    public void stop(){
        clip.stop();
    }
    public void forward(){
        clip.setMicrosecondPosition(clip.getMicrosecondPosition() + 5000000);
        play();
    }
    public void backward(){
        clip.setMicrosecondPosition(clip.getMicrosecondPosition() - 5000000);
        play();
    }
    public void Restart(int id) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        clip.stop();
        clip.close();
        playerreset(id);
        currentFrame=0L;
        clip.setMicrosecondPosition(currentFrame);
        play();
    }
    public void play(){
        clip.start();
        System.out.println("playing");
    }
    public void Jump(){

    }
}
