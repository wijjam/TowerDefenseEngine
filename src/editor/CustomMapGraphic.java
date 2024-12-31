package editor;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.ArrayList;

public class CustomMapGraphic {

    JFrame f;
    JPanel north;
    JPanel south;
    JPanel east;
    JPanel west;
    CustomMapCanvas customMapCanvas;

    public CustomMapGraphic () {
        f = new JFrame("Editor");
        f.setLayout(new BorderLayout());
        north = new JPanel();
        south = new JPanel();
        east = new JPanel();
        west = new JPanel();
        customMapCanvas = new CustomMapCanvas();
        f.add(customMapCanvas, BorderLayout.CENTER);
        f.add(north, BorderLayout.NORTH);
        f.add(south, BorderLayout.SOUTH);
        f.add(east, BorderLayout.EAST);
        f.add(west, BorderLayout.WEST);
        north.setPreferredSize(new Dimension(1000, 100));
        south.setPreferredSize(new Dimension(1000, 150));
        east.setPreferredSize(new Dimension(265, 800));
        west.setPreferredSize(new Dimension(270, 800));
        f.setSize(new Dimension(1000, 800));
        f.setVisible(true);

    }


}
