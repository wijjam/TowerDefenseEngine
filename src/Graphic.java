import javax.swing.*;
import java.awt.*;

public class Graphic extends Frame {
    private JFrame f;

    public Graphic () {
        f = new JFrame("Nice game");
        f.setSize(new Dimension(1000, 800));
        f.setResizable(false);
        f.setLayout(new BorderLayout());
        f.add(new Menu(), BorderLayout.CENTER);
        f.setVisible(true);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
