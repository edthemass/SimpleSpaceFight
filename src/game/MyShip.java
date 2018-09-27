/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.KeyStroke;

/**
 *
 * @author eas7.de-play
 */
public class MyShip implements KeyListener {

    int x, y;
    Polygon polygon;
    int[] xPoints = {0, 20, 40};
    int[] yPoints = {30, 0, 30};
    int nPoints = 3;
    MyCanvas canvas;
    boolean left, right, shoot;

    public MyShip(MyCanvas c, MyImages i) {
        polygon = new Polygon(xPoints, yPoints, nPoints);
        polygon.translate(400, 500);
        this.canvas = c;
        addKeyListener();
    }

    private void addKeyListener() {
        canvas.addKeyListener(this);
        // TODO ??? weiss nicht warum das nur mit dem Funktioniert und was F2 actionNAme bedeutet
        canvas.getInputMap().put(KeyStroke.getKeyStroke("F2"), "actionName");
    }

    public void draw(Graphics2D g2d) {
        g2d.drawPolygon(polygon);
    }

    private void shooting() {
        shoot = true;
        //new Bullet();
        System.out.println("baaahhmmmm");
    }

    public void update() {
        if ((polygon.xpoints[0] > 0) && (left)) {
            polygon.translate(-5, 0);
        }
        // TODO Definiere Bildschirmgrösse durch Variable
        if ((polygon.xpoints[2] <= (800 - 20)) && (right)) {
            polygon.translate(+5, 0);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_A) {
            left = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_D) {
            right = true;
        }
        if ((e.getKeyCode() == KeyEvent.VK_SPACE) && (!shoot)) {
            shooting();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_A) {
            left = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_D) {
            right = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            shoot = false;
        }
    }

}
