/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package game;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author P01004090
 */
public class GameWindow extends JFrame{

    private final GamePanel gp;
    public GameWindow() {
        
        this.gp = new GamePanel();
        
        add(gp);
        pack();
        setTitle("GAME");
        setLocation(200,200);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setVisible(true);
    }
    
}
