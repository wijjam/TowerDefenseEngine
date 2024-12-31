import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class MapWriter extends JPanel {

    String fileName;

    File f;


    public MapWriter(String fileName) {

        f = new File(fileName);
        this.setBackground(Color.white);
    }

    public String[][] importMaps() throws FileNotFoundException {

        String[][] maps = new String[15][15];

        Scanner scanner = new Scanner(f);

        for (int i = 0; i < 15; i++) {
            for (int k = 0; k < 15; k++) {
                String line = scanner.next();
                maps[k][i] = line;
            }
        }
        scanner.close();

        return maps;
    }



}
