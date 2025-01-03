import java.awt.*;
import javax.swing.*;

class LosangeExample extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Cast to Graphics2D for better control
        Graphics2D g2d = (Graphics2D) g;

        // Set the color to draw the rhombus (you can change it)
        g2d.setColor(Color.BLUE);

        // Set the stroke thickness (optional)
        g2d.setStroke(new BasicStroke(2));

        // Coordinates for the losange (rhombus)
        int centerX = 100;  // X-coordinate of the center
        int centerY = 100;  // Y-coordinate of the center
        int size = 100;      // The size of the rhombus (distance from center to corners)

        // Define the four points of the rhombus (top, right, bottom, left)
        int[] xPoints = {centerX, centerX + size, centerX, centerX - size};
        int[] yPoints = {centerY - size, centerY, centerY + size, centerY};

        // Draw the rhombus
        g2d.drawPolygon(xPoints, yPoints, 4);  // 4 sides for the losange
    }

    public static void main(String[] args) {
        // Create a frame to display the panel
        JFrame frame = new JFrame();
        LosangeExample panel = new LosangeExample();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.add(panel);
        frame.setVisible(true);
    }
}
