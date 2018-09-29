/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.Graphics2D;
import java.awt.Polygon;

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
    MyImages images;
    Bullet bulletTest;
    boolean killed;
    int timer = 100;
    int travelSide = +2;
    int travelUpDown = +1;
    MySounds sounds;

    public Enemy(MyCanvas c, MyImages i, int x, int y, MySounds s) {
        this.x = x;
        this.y = y;
        this.sounds = s;
        this.images = i;
        polygon = new Polygon(xPoints, yPoints, nPoints);
        polygon.translate(x, y);
        this.canvas = c;
    }

    public void move() {

        // Wichtig für getroffen werden
        x = polygon.getBounds().x;
        y = polygon.getBounds().y;
        polygon.translate(travelSide, travelUpDown);
        if (x <= 0) {
            travelSide = +2;
        }
        // -80 Feindgrösse sonst fliegt dieser aus Bildschirm
        if (x >= 800 - 80) {
            travelSide = -2;
        }
        if (y < 40) {
            travelUpDown = +1;
        }
        if (y > 400) {
            travelUpDown = -1;
        }
    }

    public void draw(Graphics2D g2d) {
        g2d.drawPolygon(polygon);
        g2d.drawImage(images.getImg(2), x, y, null);
    }

    private void shooting() {
        //new Bullet();
        sounds.playSound(0);
        canvas.init.bullets.add(new Bullet(images, polygon.xpoints[1], polygon.ypoints[1], true, sounds));
    }

    public void update() {
        // Random Schuß
        if (timer < 0) {
            shooting();
            timer = 100;
        }
        timer--;

        move();
    }
}
