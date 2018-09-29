/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import com.sun.javafx.application.PlatformImpl;
import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.net.MalformedURLException;
import java.util.ArrayList;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 *
 * @author P01004090
 */
public class MySounds {

    String PATH = "src\\game\\sounds\\";
    String[] gameSounds = {"hit1.wav", "destroyd.wav", "hit2.wav", "explo1.wav", "a.WAV"};
    MediaPlayer mediaPlayer;
    ArrayList<Media> hitList = new ArrayList<>();

    public MySounds() {
        PlatformImpl.startup(() -> {
        });
//        new MySounds();
//        Media hitList = new Media(new File(PATH + gameSounds[0]).toURI().toString());
//        MediaPlayer mediaPlayer = new MediaPlayer(hitList);
//        mediaPlayer.play();
        for(int i = 0; i < gameSounds.length; i++){
            hitList.add(new Media(new File(PATH + gameSounds[i]).toURI().toString()));
        }
        

    }

    public void getSound(int i) {
        mediaPlayer = new MediaPlayer(hitList.get(i));
        mediaPlayer.play();
    }
}
