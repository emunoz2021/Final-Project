package zoosimulator;

import javax.swing.*;
import java.awt.*;

public class HabitatPanel extends JPanel {
    private ImageIcon backgroundImage;

    public HabitatPanel(String imagePath) {
        this.backgroundImage = new ImageIcon(imagePath);
        this.setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage.getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
    }
}