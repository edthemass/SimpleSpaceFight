/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics2D;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author P01004090
 */
public class MyInterface {

    String hits = "0";
    int myHits = 0;
    boolean gameOver = false;
    Font font40, font20;

    public MyInterface() {
        try {

            font40 = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("src\\game\\fonts\\OldGameFatty.ttf")).deriveFont(40f);
            font20 = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("src\\game\\fonts\\OldGameFatty.ttf")).deriveFont(20f);

        } catch (FontFormatException | IOException ex) {
            Logger.getLogger(MyInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void draw(Graphics2D g2d) {

        g2d.setFont(font20);
        g2d.setColor(Color.white);
        g2d.drawString("kills " + hits, 0, 20);

        if (gameOver) {
            g2d.setFont(font40);
            g2d.drawString("GAME OVER", 280, 300);
        }
    }

    public void update() {
        hits = Integer.toString(myHits);
    }

}
