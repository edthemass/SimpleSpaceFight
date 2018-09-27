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
public class Bullet {

    int[] xPoints = {0, 3, 6};
    int[] yPoints = {3, 0, 3};
    int nPoints = 3;
    int x, y;
    Polygon polygon;
    boolean out = false;

    public Bullet(int x, int y) {
        this.x = x;
        this.y = y;
        polygon = new Polygon(xPoints, yPoints, nPoints);
        polygon.translate(x, y);
    }

    public void draw(Graphics2D g2d) {
        g2d.drawPolygon(polygon);
    }

    public void update() {
        // -3 Geschwindigkeit
        polygon.translate(0, -3);
        if (polygon.ypoints[1] < 0) {
            System.out.println("out of place");
            out = true;
        }
    }

}
