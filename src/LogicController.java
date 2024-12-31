import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;

public class LogicController {

    private String[][] groundName;
    private ArrayList<Blocks> block;
    private GameBoard gameBoard;
    private int pathX, pathY;
    private ArrayList<PlacedTowers> towers;
    private ArrayList<Enemy> enemies;
    private boolean canSpawn;
    private TowerLogic towerLogic;
    private SideMenu sideMenu;

    private ArrayList<Enemy> currentSection;
    private SectionLogic sectionLogic;

    LogicController(ArrayList<Blocks> block, String[][] groundName, GameBoard gameBoard, ArrayList<PlacedTowers> towers, TowerLogic towerLogic, SideMenu sideMenu) {
        this.block = block;
        this.towers = towers;
        this.groundName = groundName;
        this.gameBoard = gameBoard;
        this.enemies = new ArrayList<>();
        createEnemy();
        spawnCoolDown();
        this.sideMenu = sideMenu;
        this.towerLogic = towerLogic;
        this.sectionLogic = new SectionLogic();
        this.currentSection = new ArrayList<>();

    }

    public void render(Graphics2D g2d, ArrayList<Blocks> block, String[][]
            groundName) {

        gameBoard.drawMap(g2d, block, groundName);
        gameBoard.drawTower(g2d);
        for (Enemy enemy: enemies) {
            enemy.drawEnemy(g2d);
        }
    }


    public void updateGame() {
        createEnemy();

        for (Enemy enemy: enemies) {
            enemy.moveEnemy(groundName);
            sectionLogic.checkSectionState(enemy);
        }



        for (PlacedTowers tower: towers) {
            if (tower.getSections().equals(Sections.NORTHEAST)) {
                currentSection = sectionLogic.getNorthEast();
            } else if (tower.getSections().equals(Sections.NORTHWEST)) {
                currentSection = sectionLogic.getNorthWest();
            } else if (tower.getSections().equals(Sections.SOUTHEAST)) {
                currentSection = sectionLogic.getSouthEast();
            } else if (tower.getSections().equals(Sections.SOUTHWEST)) {
                currentSection = sectionLogic.getSouthWest();
            }
            tower.checkIfHit(currentSection);
        }
    }

    public void createEnemy() {
        if (canSpawn) {
            for (int i = 0; i <= 14; i++) {
                for (int ii = 0; ii <= 14; ii++) {
                    if (Objects.equals(groundName[i][ii], Ground.START.name())) {
                        pathX = i * StateValues.BLOCKMARGIN;
                        pathY = ii * StateValues.BLOCKMARGIN;
                        // will be added on to include different enemy types with different parameters.
                        enemies.add(new Enemy(pathX, pathY, groundName, block, towers));
                        canSpawn = false;
                    }
                }
            }
        }
    }


    private void spawnCoolDown(){
        new Timer(500, e->canSpawn = true).start();
    }


}
