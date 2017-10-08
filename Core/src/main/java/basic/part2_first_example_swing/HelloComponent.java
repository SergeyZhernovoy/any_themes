package basic.part2_first_example_swing;

import javax.swing.*;
import java.awt.*;

/**
 * @author Sergey Zhernovoy
 * create on 30.07.2017.
 */

public class HelloComponent extends JComponent{


    @Override
    protected void paintComponent(Graphics g) {
        g.drawString("Hello world !!!", 125,95);
    }

    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        jFrame.add(new HelloComponent4("Hello Java !!!"));
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(300,300);
        jFrame.setVisible(true);
    }
}

    