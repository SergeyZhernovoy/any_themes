package pattern_observer.swing_example;

import javax.swing.*;
import java.awt.*;

public class SwingObserverExample  {
    private JFrame jFrame;

    public void go() {
        jFrame = new JFrame();
        JButton jButton = new JButton("Should I do it ?");
        jButton.addActionListener(event->{
            System.out.println("Devil say : Come on, do it!");
        });

        jButton.addActionListener(event->{
            System.out.println("Angel say: Don't do it, you might regret it !");
        });

        jFrame.getContentPane().add(BorderLayout.CENTER, jButton);
        jFrame.setVisible(true);
    }

    public static void main(String[] args) {
        new SwingObserverExample().go();
    }
}
