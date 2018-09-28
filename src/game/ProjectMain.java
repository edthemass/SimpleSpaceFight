/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author p01004090
 */
public class ProjectMain {
    private static Dimension frameSize = new Dimension(800,600);
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(frameSize);
        // ONLY TESTING
        frame.setLocation(200, 300);
        frame.setResizable(false);
//        frame.setLocationRelativeTo(null);
        frame.add(new MyCanvas(frameSize));
//        canvas.setFrameSize();
        frame.setVisible(true);    
               
//        System.out.println(ergebnis[0][0]);
//        System.out.println(ergebnis[1][0]);
//        new GameWindow();
    }
    
}
