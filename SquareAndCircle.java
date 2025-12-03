
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class SquareAndCircle extends JPanel {

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw a square
        g.setColor(Color.BLUE);
        g.fillRect(100, 100, 100, 100);

        // Draw a circle
        g.setColor(Color.RED);
        g.fillOval(250, 100, 100, 100);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Square and Circle");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);
        SquareAndCircle panel = new SquareAndCircle();
        frame.add(panel);
        frame.setVisible(true);
    }
}
