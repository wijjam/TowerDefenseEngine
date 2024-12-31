import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class GameBoard extends JPanel {

    ArrayList<Blocks> block;
    String[][] groundName;
    LogicController logicController;
    GameLoop gameLoop;
    SideMenu sideMenu;
    int blockWidth = 49;
    int blockHeight = 49;
    ArrayList<PlacedTowers> towers;
    TowerLogic towerLogic;
    BufferedImage image;
    BufferedImage grassImage;
    BufferedImage pathImage;
    public GameBoard(String fileName, ArrayList<PlacedTowers> towers) {
        this.towers = towers;
        try {
            image = ImageIO.read(new File("src/sprite/Tower.png"));
            grassImage = ImageIO.read(new File("src/sprite/GRASS.png"));
            pathImage = ImageIO.read(new File("src/sprite/PATH.png"));
        } catch (IOException e) {
            System.out.println("Image can't be loaded from file");
        }
        block = new ArrayList<>();
        MapWriter mapWriter = new MapWriter(fileName);
        try {
            groundName = mapWriter.importMaps();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        sideMenu = new SideMenu(towers);
        towerLogic = new TowerLogic(this, block, towers, sideMenu, image);
        sideMenu.setTowerLogic(towerLogic);
        logicController = new LogicController(block, groundName, this, towers, towerLogic, sideMenu);
        gameLoop = new GameLoop(logicController, this);
        gameLoop.start();
        this.setLayout(new BorderLayout());
        this.add(sideMenu, BorderLayout.EAST);
    }


    public void drawMap(Graphics2D g2d, ArrayList<Blocks> block, String[][] groundName) {
        for (int i = 0; i <= 14; i++) {
            for (int k = 0; k <= 14; k++) {
                if (Objects.equals(groundName[k][i], Ground.GRASS.name())) {
                    g2d.drawImage(grassImage, StateValues.BLOCKMARGIN * k, StateValues.BLOCKMARGIN * i, this);
                    block.add(new Blocks(k, i, Ground.GRASS));
                } else if (Objects.equals(groundName[k][i], Ground.PATH.name())) {
                    g2d.drawImage(pathImage, StateValues.BLOCKMARGIN * k, StateValues.BLOCKMARGIN * i, this);
                    block.add(new Blocks(k, i, Ground.PATH));
                } else if (Objects.equals(groundName[k][i], Ground.WITHER.name())) {
                    g2d.setColor(Color.MAGENTA);
                    block.add(new Blocks(k, i, Ground.WITHER));
                } else if (Objects.equals(groundName[k][i], Ground.START.name())) {
                    g2d.setColor(new Color(50,255,150));
                    block.add(new Blocks(k, i, Ground.START));
                } else if (Objects.equals(groundName[k][i], Ground.END.name())) {
                    g2d.setColor(new Color(114, 4, 16));
                    block.add(new Blocks(k, i, Ground.END));
                }
                 //g2d.fillRect(StateValues.BLOCKMARGIN * k, StateValues.BLOCKMARGIN * i, blockWidth, blockHeight);
            }
        }
    }

    public void drawTower(Graphics2D g2d) {
        for (PlacedTowers tower : towers) {
            g2d.drawImage(image,tower.x * StateValues.BLOCKMARGIN, tower.y * StateValues.BLOCKMARGIN, this);
        }
    }



    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        logicController.render(g2d, block, groundName);

    }
}
