/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Polygon;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
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
    int coolDown;
    MyCanvas canvas;
    MyImages images;
    boolean left, right, shoot;
    boolean killed = false;
    MySounds sounds;

    // invisible = letzten wert auf null setzten, zum testen anlassen
    Color polygonShipColour = new Color(0, 0, 0, 200);

    public MyShip(MyCanvas c, MyImages img, MySounds s) {
        polygon = new Polygon(xPoints, yPoints, nPoints);
        polygon.translate(400, 500);
        this.sounds = s;
        this.canvas = c;
        this.images = img;
        addKeyListener();

    }

    private void addKeyListener() {
        canvas.addKeyListener(this);
        // TODO ??? weiss nicht warum das nur mit dem Funktioniert und was F2 actionNAme bedeutet
        canvas.getInputMap().put(KeyStroke.getKeyStroke("F2"), "actionName");
    }

    public void draw(Graphics2D g2d) {
        if (!killed) {
            g2d.setColor(polygonShipColour);
            g2d.drawPolygon(polygon);
            g2d.drawImage(images.getImg(0), x, y, null);
        }
    }

    private void shooting() {
        sounds.getSound(2);
        canvas.init.bullets.add(new Bullet(images, polygon.xpoints[1], polygon.ypoints[1], false, sounds));
    }

    public void update() {
        x = polygon.getBounds().x;
        y = polygon.getBounds().y;

        if ((polygon.xpoints[0] > 0) && (left)) {
            polygon.translate(-5, 0);
        }
        // TODO Definiere Bildschirmgrösse durch Variable
        if ((polygon.xpoints[2] <= (800 - 20)) && (right)) {
            polygon.translate(+5, 0);
        }

        // Salvenschießen
        if ((shoot) && (!killed)) {

            if (coolDown <= 0) {
                shooting();
                coolDown = 50;
            }
            coolDown--;
            
        }
        if(!shoot)coolDown = 0;
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
            shoot = true;
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
