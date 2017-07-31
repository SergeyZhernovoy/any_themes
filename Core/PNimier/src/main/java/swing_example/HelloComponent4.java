package swing_example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

/**
 * Created by Sergey on 31.07.2017.
 */
public class HelloComponent4 extends JComponent implements MouseMotionListener, ActionListener,Runnable {
    private static final Logger logger = LoggerFactory.getLogger(HelloComponent3.class);

    private String message;
    private int xPosition = 125, yPosition = 125;
    private JButton jButton;
    private int colorIndex;
    private boolean blinkState;
    static Color[] someColor = {Color.black,Color.blue,Color.red, Color.green};

    public HelloComponent4(String message){
        this.message = message;
        jButton = new JButton("Изменить цвет");
        setLayout(new FlowLayout());
        add(jButton);
        jButton.addActionListener(this);
        addMouseMotionListener(this);
        Thread thread = new Thread(this);
        thread.start();

    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(blinkState ? getBackground() : currentColor());
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

    private synchronized Color currentColor() {
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

    @Override
    public void run() {
        try{
            while(true){
                blinkState = !blinkState;
                repaint();
                Thread.sleep(300);
            }

        } catch (InterruptedException exc){
            exc.printStackTrace();
        }
    }
}
