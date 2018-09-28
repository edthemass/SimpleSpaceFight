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
public class MyInterface {

    String hits = "0";
    int myHits = 0;
    boolean gameOver = false;
    
    
    public MyInterface() {

    }

    public void draw(Graphics2D g2d) {
        g2d.drawString("kills " + hits, 0, 20);
        if(gameOver)g2d.drawString("GAME OVER", 300, 300);
        
    }

    public void update() {
        hits = Integer.toString(myHits);
    }

}
