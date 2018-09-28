/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author p01004090
 */
public class Init {

    MyCanvas c;
    MyImages images;
    MyShip myShip;
    MyInterface myInterface;
    ArrayList<Bullet> bullets = new ArrayList<Bullet>();
    ArrayList<Enemy> enemys = new ArrayList<>();
    int timer;
    Random random = new Random();

    public Init(MyCanvas c, MyImages i) {
        this.c = c;
        this.images = i;
        myShip = new MyShip(c, i);
        myInterface = new MyInterface();
//        startsWar();
    }

    // TODO Doppelter Flug (Zwei Feinde übereinander verhinder) zerstreuung bei berührung
    public void newEnemy() {
        // Feindbegrenzung max 20
        if(enemys.size() < 20){
            int ranX = random.nextInt(750);
            enemys.add(new Enemy(c, images, ranX, -40));
        }
    }

    public void draw(Graphics2D g2d) {
        myInterface.draw(g2d);
        myShip.draw(g2d);
        for (int i = 0; i < bullets.size(); i++) {
            bullets.get(i).draw(g2d);
        }
        for (int i = 0; i < enemys.size(); i++) {
            enemys.get(i).draw(g2d);
        }

    }
    
    // TODO Doppelter Flug (Zwei Feinde übereinander verhinder) zerstreuung bei berührung
    public void update() {
        --timer;
        if(timer < 0){
            timer = random.nextInt(100) + 100;
            newEnemy();
        }
        
        myShip.update();
        myInterface.update();

        for (int i = 0; i < bullets.size(); i++) {
            if (myShip.polygon.contains(bullets.get(i).polygon.getBounds())) {
                myShip.killed = true;
                myInterface.gameOver = true;
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
                    if(!bullets.get(j).enemyShoot){
                        enemys.get(i).killed = true;
                        bullets.remove(j);
                    }
                }
            }
            // wenn Enemy flag auf Tot steht sterben
            if (enemys.get(i).killed == true) {
                enemys.remove(i);
                myInterface.myHits += 1;
            }
        }

    }
}
