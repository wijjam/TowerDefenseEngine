package editor;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MousePressedListener implements MouseListener {

    public MousePressedListener() {

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("X coord: " + e.getX() + " " + "Y coord: " + e.getY());
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
