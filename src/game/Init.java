/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.Graphics2D;
import java.util.ArrayList;

/**
 *
 * @author p01004090
 */
public class Init {
//    MyCanvas canvas;

    MyShip myShip;
    ArrayList<Bullet> bullets = new ArrayList<Bullet>();
    ArrayList<Enemy> enemys = new ArrayList<>();

    public Init(MyCanvas c, MyImages i) {
//        this.canvas = c;
        myShip = new MyShip(c, i);
//        bullets = new ArrayList<>();
        enemys.add(new Enemy(c, i, 200, 0));
    }

    public void draw(Graphics2D g2d) {
        myShip.draw(g2d);
        for (int i = 0; i < bullets.size(); i++) {
            bullets.get(i).draw(g2d);
        }
        for (int i = 0; i < enemys.size(); i++) {
            enemys.get(i).draw(g2d);
        }

    }

    public void update() {
        myShip.update();

        for (int i = 0; i < bullets.size(); i++) {
            if (myShip.polygon.contains(bullets.get(i).polygon.getBounds())) {
                myShip.killed = true;
            }
        }
        // Bullets Flug und Spielfeld verlassen. Gilt für beide Seiten
        for (int i = 0; i < bullets.size(); i++) {
            bullets.get(i).update();
            if (bullets.get(i).out == true) {
                bullets.remove(i);
            }
        }

        // Schuss auf Feind prüfen
        for (int i = 0; i < enemys.size(); i++) {
            enemys.get(i).update();
            if (enemys.get(i).killed == true) {
                enemys.remove(i);
            }
            // wenn Feind geetroffen wird = löschen und Kugel auch
            for (int j = 0; j < bullets.size(); j++) {
                if (enemys.get(i).polygon.contains(bullets.get(j).polygon.getBounds())) {
                    enemys.remove(i);
                    bullets.remove(j);
                }
            }
        }
    }
}
