/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.Graphics2D;
import java.awt.Polygon;
import javax.swing.KeyStroke;

/**
 *
 * @author P01004090
 */
public class Enemy {

    int x, y;
    Polygon polygon;
    int[] xPoints = {0, 30, 60};
    int[] yPoints = {0, 40, 0};
    int nPoints = 3;
    MyCanvas canvas;
    Bullet bulletTest;
    boolean killed;
    int timer = 100;

    public Enemy(MyCanvas c, MyImages i, int x, int y) {
        this.x = x;
        this.y = y;
        polygon = new Polygon(xPoints, yPoints, nPoints);
        polygon.translate(x, y);
        this.canvas = c;

    }
    int travel = +2;
    public void move() {
        
        // Wichtig für getroffen werden
        x = polygon.getBounds().x;
        y = polygon.getBounds().y;
        polygon.translate(travel, 0);
        if(x <= 0){
            travel = +2;
        }
        // -60 Feindgrösse
        if(x >= 800 - 80){
            travel = -2;
        }
    }

    public void draw(Graphics2D g2d) {
        g2d.drawPolygon(polygon);
    }

    private void shooting() {
        //new Bullet();
//        canvas.init.bullets.add(new Bullet(polygon.xpoints[1], polygon.ypoints[1]));
    }

    public void update() {
        if (timer < 0) {
            shooting();
            timer = 100;
            System.err.println("feind angriff");
        }
        timer--;
        
        move();
    }
}
