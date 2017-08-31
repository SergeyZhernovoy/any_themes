package part2_first_example_swing;/**
 * @author Sergey Zhernovoy
 * create on 30.07.2017.
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class HelloComponent2 extends JComponent implements MouseMotionListener {
    private static final Logger logger = LoggerFactory.getLogger(HelloComponent2.class);
    private String message;
    private int xPosition = 125, yPosition = 125;

    public HelloComponent2(String message){
        this.message = message;
        addMouseMotionListener(this);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        this.xPosition = e.getX();
        this.yPosition = e.getY();
        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }


    @Override
    protected void paintComponent(Graphics g) {
        g.drawString(this.message, this.xPosition, this.yPosition);
    }
}

    