package swing_example;/**
 * @author Sergey Zhernovoy
 * create on 30.07.2017.
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class HelloComponent3 extends JComponent implements MouseMotionListener, ActionListener {
    private static final Logger logger = LoggerFactory.getLogger(HelloComponent3.class);

    private String message;
    private int xPosition = 125, yPosition = 125;
    private JButton jButton;
    private int colorIndex;
    static Color[] someColor = {Color.black,Color.blue,Color.red, Color.green};

    public HelloComponent3(String message){
        this.message = message;
        jButton = new JButton("Изменить цвет");
        setLayout(new FlowLayout());
        add(jButton);
        jButton.addActionListener(this);
        addMouseMotionListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawString(this.message, this.xPosition, this.yPosition);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == jButton){
            changeColor();
        }
    }

    private synchronized   void changeColor() {
        if(++colorIndex == someColor.length) {
            colorIndex = 0;
        }
        setForeground(currentColor());
    }

    private Color currentColor() {
        return someColor[colorIndex];
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
}

    