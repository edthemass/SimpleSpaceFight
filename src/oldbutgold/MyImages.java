/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oldbutgold;

import java.awt.Image;
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
public class MyImages {
    
    ArrayList<Image> image;
    
    final String IMG_PATH = "src\\images\\";
    final String[] IMG_NAME = {/*"s01_20_20.png", "p01_50_50.png" , "d01_24_24.png"*/};
    
    public MyImages() {
        image = new ArrayList<Image>();
        loadImages();
    }
    
    void loadImages(){
        
        try {
            for(int i = 0; i < IMG_NAME.length; i++){
                image.add(ImageIO.read(new File(IMG_PATH + IMG_NAME[i])));
            }
        } catch (IOException ex) {
            Logger.getLogger(MyImages.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Image getImage(int i){
        return image.get(i);
    }
}
