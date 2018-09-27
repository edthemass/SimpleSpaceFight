/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package game;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;

/**
 *
 * @author P01004090
 */
public class MyShip extends GameObject {
    
    Polygon polygon;
    int[] xPoints = {0, 20, 40};
    int[] yPoints = {30, 0, 30};
    int nPoints = 3;
    
    public MyShip(Coordinate position) {
        super(null, 0, 0);
        polygon = new Polygon(xPoints, yPoints, nPoints);
        polygon.translate((int) position.getX(),(int) position.getY());
    }
    
    private void paintShip(Graphics2D g2d) {
        g2d.drawPolygon(polygon);
    }
    
    @Override
    protected void paintMe(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;        
        paintShip(g2d);
    }
    
}
