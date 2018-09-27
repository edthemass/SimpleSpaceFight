/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.Graphics2D;

/**
 *
 * @author p01004090
 */
public class Init {
    MyShip myShip;
    public Init(MyCanvas c, MyImages i) {
        myShip = new MyShip(c,i);
    }
    
    public void draw(Graphics2D g2d){
        myShip.draw(g2d);
    }
    
    public void update(){
        myShip.update();
    }
}
