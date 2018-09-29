/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import com.sun.javafx.application.PlatformImpl;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;


/**
 *
 * @author P01004090
 */
public class MySounds {

    String PATH = "src\\game\\sounds\\";
    String[] gameSounds = {"hit1.wav", "destroyd.wav", "hit2.wav", "explo1.wav", "a.WAV"};
    MediaPlayer mediaPlayer;
    ArrayList<Media> hitList = new ArrayList<>();
    AudioStream theStream = null;

    public MySounds() {
        PlatformImpl.startup(() -> {
        });
//        new MySounds();
//        Media hitList = new Media(new File(PATH + gameSounds[0]).toURI().toString());
//        MediaPlayer mediaPlayer = new MediaPlayer(hitList);
//        mediaPlayer.play();
        for (int i = 0; i < gameSounds.length; i++) {
            hitList.add(new Media(new File(PATH + gameSounds[i]).toURI().toString()));
        }

    }
    
    public void update(){
        
    }
    
    public void playMusik() { 
        try {
            theStream = new AudioStream(new FileInputStream(PATH + "beat.wav"));
        } catch (IOException ex) {
            Logger.getLogger(MySounds.class.getName()).log(Level.SEVERE, null, ex);
        }
        AudioPlayer.player.start(theStream);
    }

    public void playSound(int i) {
        mediaPlayer = new MediaPlayer(hitList.get(i));
        mediaPlayer.play();
    }
}
