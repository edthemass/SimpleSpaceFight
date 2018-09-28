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
    
    MyImages images;
    Polygon polygon;
    boolean out = false;
    boolean enemyShoot;
    
    public Bullet(MyImages img, int x, int y, boolean sh) {
        this.enemyShoot = sh;
        this.x = x;
        this.y = y;
        this.images = img;
        polygon = new Polygon(xPoints, yPoints, nPoints);
        polygon.translate(x, y);
    }

    public void draw(Graphics2D g2d) {
        g2d.drawPolygon(polygon);
        g2d.drawImage(images.getImg(1), x, y, null);
    }

    public void update() {
        
        x = polygon.getBounds().x;
        y = polygon.getBounds().y;
        
        // -3 Geschwindigkeit
        if(!enemyShoot){
            polygon.translate(0, -3);
            if (polygon.ypoints[1] < 0) {
                out = true;
            }
        }
        if(enemyShoot){
            polygon.translate(0, +3);
            if (polygon.ypoints[1] > 600) {
                out = true;
            }
        }
        
        
    }

}
