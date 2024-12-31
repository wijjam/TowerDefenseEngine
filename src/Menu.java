import editor.CustomMapGraphic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class Menu extends JPanel {
        JButton startButton;
        JPanel panel;
        JButton editorButton;
        JComboBox<String> comboBox;
        String fileName;
        GameBoard gameBoard;
        ArrayList<PlacedTowers> towers;
        public Menu() {
            this.editorButton = new JButton("Edit");
            towers = new ArrayList<>();
            setLayout(new BorderLayout());
            comboBox = new JComboBox<>(new String[]{"GrassLand", "WitheredLand"});
            startButton = new JButton("Start Game");
            fileName = "GrassLand";
            panel = new JPanel();
            this.add(panel, BorderLayout.CENTER);
            panel.add(comboBox, BorderLayout.NORTH);
            panel.add(startButton, BorderLayout.SOUTH);
            panel.add(editorButton, BorderLayout.EAST);
            startButton.addActionListener(this::StartGame);
            comboBox.addActionListener(this::selectMap);
            editorButton.addActionListener(this::mapEditor);


        }

    private void mapEditor(ActionEvent actionEvent) {

        CustomMapGraphic customMapGraphic = new CustomMapGraphic();

    }

    private void selectMap(ActionEvent actionEvent) {
            fileName = comboBox.getItemAt(comboBox.getSelectedIndex());
            System.out.println(fileName);
    }


    private void StartGame(ActionEvent actionEvent) {
            // Uses revalidate to update JPanel, so it notices that mapWriter has been added to the panel and then paints out the map.
            gameBoard = new GameBoard("src/maps/" + fileName + ".json", towers);
            gameBoard.setBackground(Color.white);
            this.add(gameBoard, BorderLayout.CENTER);
            this.remove(startButton);
            this.remove(panel);
            revalidate();
        }

}
