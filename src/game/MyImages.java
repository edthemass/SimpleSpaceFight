/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author p01004090
 */
public final class MyImages {
    
    private String PATH = "src\\game\\images\\";
    private String[] SOURCE = {"myShip.png"};
    private ArrayList<Image> image;
    BufferedImage img = null;

    public MyImages() {
        image = new ArrayList<>();
        try {
            for(int i = 0; i< SOURCE.length; i++){
                img = ImageIO.read(new File(PATH + SOURCE[i]));
                image.add(img);
            }
        } catch (IOException ex) {
            Logger.getLogger(MyImages.class.getName()).log(Level.SEVERE, null, ex);
        }
        //System.err.println(img);
    }
    
    public Image getImg(int i){
        return image.get(i);
    }
}
