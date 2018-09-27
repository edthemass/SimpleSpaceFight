/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oldbutgold;

import oldbutgold.MyShip;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author P01004090
 */
public class GamePanel extends JPanel {

    public static final String IMAGE_DIR = "images/";

    private final Dimension prefSize = new Dimension(800, 600);

    private ImageIcon backgroundImage;

    private Timer t;
    private MyShip ms;

    public GamePanel() {
        // TODO ??? Was macht das
        setFocusable(true);
        setPreferredSize(prefSize);

        initGame();
        startGame();
    }

    private void initGame() {
        // TODO Setzte Hintergrungbild...
        createGameObjects();

        t = new Timer(20, (ActionEvent e) -> {
            doOnTick();
        });

    }

    void createGameObjects() {
        ms = new MyShip(new Coordinate(400,500));
    }

    private void startGame() {
        t.start();
    }

    int test = 0;
    private void doOnTick() {
        repaint();
        System.out.println("tick" + test++);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.drawString("Tanks destroyed:", 10,10);
        
        ms.paintMe(g);
    }
}
