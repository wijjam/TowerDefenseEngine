package editor;

import javax.swing.*;
import java.awt.*;

public class CustomMapCanvas extends JPanel {

    MousePressedListener mousePressedListener;
    public CustomMapCanvas() {
        mousePressedListener = new MousePressedListener();
        this.addMouseListener(mousePressedListener);
    }


    public void drawCanvas(Graphics2D g2d) {
        for (int i = 0; i < 15; i++) {
            for (int ii = 0; ii < 15; ii++) {
                g2d.setColor(Color.GREEN);
                g2d.fillRect(i * 30, ii * 30, 29, 29);
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        drawCanvas((Graphics2D) g);

    }
}
