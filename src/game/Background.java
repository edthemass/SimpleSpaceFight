/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package game;

import java.awt.Graphics2D;

/**
 *
 * @author P01004090
 */
public class Background {

    MyImages images;
    int y1, y2 = -600;
    
    public Background(MyImages img) {
        this.images = img;
    }
    
    public void draw(Graphics2D g2d){
        g2d.drawImage(images.getImg(3), 0, y1, null);
        g2d.drawImage(images.getImg(3), 0, y2, null);
    }
    
    public void update(){
        y1 += 1;
        y2 += 1;
        if(y1 >= 600){
            y1 = 0;
        }
        if(y2 >= 0){
            y2 = -600;
        }
        
    }
    
}
