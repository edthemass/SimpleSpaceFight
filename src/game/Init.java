/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Random;
import javax.sound.sampled.LineUnavailableException;

/**
 *
 * @author p01004090
 */
public class Init {

    MyCanvas c;
    MyImages images;
    MySounds sounds;
    MyShip myShip;
    MyInterface myInterface;
    Background bground;
    ArrayList<Bullet> bullets = new ArrayList<Bullet>();
    ArrayList<Enemy> enemys = new ArrayList<>();
    int timer;
    int ranX;
    Random random = new Random();

    public Init(MyCanvas c, MyImages i){
        this.c = c;
        this.images = i;
        sounds = new MySounds();
        myShip = new MyShip(c, i, sounds);
        myInterface = new MyInterface();
        bground = new Background(i);
        
        sounds.playMusik();
    }

    // TODO Doppelter Flug (Zwei Feinde übereinander verhinder) zerstreuung bei berührung
    public void newEnemy() {
        // Feindbegrenzung max 20
        if (enemys.size() < 20) {
            ranX = random.nextInt(750);
            enemys.add(new Enemy(c, images, ranX, -60, sounds));
        }
    }

    public void draw(Graphics2D g2d) {
        bground.draw(g2d);

        myShip.draw(g2d);
        for (int i = 0; i < bullets.size(); i++) {
            bullets.get(i).draw(g2d);
        }
        for (int i = 0; i < enemys.size(); i++) {
            enemys.get(i).draw(g2d);
        }
        myInterface.draw(g2d);
    }

    // TODO Doppelter Flug (Zwei Feinde übereinander verhinder) zerstreuung bei berührung
    public void update() {
        sounds.update();
        bground.update();

        --timer;
        if (timer < 0) {
            timer = random.nextInt(100) + 100;
            newEnemy();
        }

        myShip.update();

        int goTimer = 100;
        for (int i = 0; i < bullets.size(); i++) {
            if ((myShip.polygon.contains(bullets.get(i).polygon.getBounds())) && (!myShip.killed)) {
                sounds.playSound(3);
                myShip.killed = true;
                myInterface.gameOver = true;
                // Geschrei
                sounds.playSound(4);
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

            // wenn Feind geetroffen wird = löschen und Kugel auch
            for (int j = 0; j < bullets.size(); j++) {
                // Aber nur wenn ein Feind existiert ansonsten Exception
                if ((enemys.size() > 0) && (enemys.get(i).polygon.contains(bullets.get(j).polygon.getBounds()))) {
                    // kein FriendlyFire
                    if (!bullets.get(j).enemyShoot) {
                        enemys.get(i).killed = true;
                        bullets.remove(j);
                        
                    }
                }
            }
            // wenn Enemy flag auf Tot steht sterben
            if (enemys.get(i).killed == true) {
                enemys.remove(i);
                sounds.playSound(1);
                myInterface.myHits += 1;
            }
        }
        myInterface.update();
    }
}
