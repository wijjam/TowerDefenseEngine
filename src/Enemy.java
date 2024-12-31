import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class Enemy extends JPanel {

    int x;
    int y;
    private int health;
    private ArrayList<Blocks> block;
    private String[][] groundName;
    private String currentDirection;
    private String lastDirection;
    private int maxY;
    private int maxX;
    private Random random;
    private ArrayList<PlacedTowers> towers;
    private ArrayList<Enemy> Sections;
    private BufferedImage enemyImage;


    public Enemy(int x, int y, String[][] groundName, ArrayList<Blocks> block, ArrayList<PlacedTowers> towers) {
        this.x = x;
        this.y = y;
        health = 100;
        this.groundName = groundName;
        this.block = block;
        this.currentDirection = Direction.Right.name();
        this.lastDirection = currentDirection;
        maxX = groundName.length;
        maxY = groundName[0].length;
        this.towers = towers;
        random = new Random();
        try {
            enemyImage = ImageIO.read(new File("src/sprite/Enemy.png"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    public void drawEnemy(Graphics2D g2d) {
        if ((health > 0)) {
            g2d.setColor(Color.BLACK);
            // g2d.fillRect(x + 10, y + 10, 25, 25);
            g2d.drawImage(enemyImage, x, y, this);
        }
    }

    public void moveEnemy(String[][] groundName) {
        if (Objects.equals(currentDirection, Direction.Right.name())) {
            if (x/StateValues.BLOCKMARGIN + 1 < maxX && Objects.equals(groundName[x/StateValues.BLOCKMARGIN + 1][y/StateValues.BLOCKMARGIN], Ground.PATH.name())) {
                x += 5;
                lastDirection = currentDirection;
            } else {
                currentDirection = lookAround(groundName);
            }
        } else if (y/StateValues.BLOCKMARGIN + 1 < maxY && Objects.equals(currentDirection, Direction.Down.name())){
            if (Objects.equals(groundName[x/StateValues.BLOCKMARGIN][y/StateValues.BLOCKMARGIN + 1], Ground.PATH.name())){
                y += 5;
                lastDirection = currentDirection;
            } else {
                currentDirection = lookAround(groundName);
            }
        } else if (x/StateValues.BLOCKMARGIN - 1 >= 0 && Objects.equals(currentDirection, Direction.Left.name())){
            if (Objects.equals(groundName[(x-5)/StateValues.BLOCKMARGIN][y/StateValues.BLOCKMARGIN], Ground.PATH.name())){
                x -= 5;
                lastDirection = currentDirection;
            } else {
                currentDirection = lookAround(groundName);
            }
        } else if (y/StateValues.BLOCKMARGIN - 1 >= 0 && Objects.equals(currentDirection, Direction.Up.name())){
            if (Objects.equals(groundName[x/StateValues.BLOCKMARGIN][(y-5)/StateValues.BLOCKMARGIN], Ground.PATH.name())){
                y -= 5;
                lastDirection = currentDirection;
            } else {
                currentDirection = lookAround(groundName);
            }
        }

        // When enemy moves we check if the new position is in another section. If it is then we add it to that seciton.
        //If we change sections we add it to the arrayList with that section and then remove from the last section.
        // This will ensure that the game is more optimized as we have added a simple spatial partitioning.





    }

    private String lookAround(String[][] groundName) {

        if (x/50 + 1 < maxX && Objects.equals(groundName[x/StateValues.BLOCKMARGIN + 1][y/StateValues.BLOCKMARGIN], Ground.PATH.name()) && !Objects.equals(lastDirection, Direction.Left.name())) {
            return Direction.Right.name();
        } else if (y/50 + 1 < maxY && Objects.equals(groundName[x/StateValues.BLOCKMARGIN][y/StateValues.BLOCKMARGIN + 1], Ground.PATH.name()) && !Objects.equals(lastDirection, Direction.Up.name())) {
            return Direction.Down.name();
        } else if (x/50 - 1 >= 0 && Objects.equals(groundName[x/StateValues.BLOCKMARGIN - 1][y/StateValues.BLOCKMARGIN], Ground.PATH.name()) && !Objects.equals(lastDirection, Direction.Right.name())) {
            return Direction.Left.name();
        } else if (y/50 - 1 >= 0 && Objects.equals(groundName[x/StateValues.BLOCKMARGIN][y/StateValues.BLOCKMARGIN - 1], Ground.PATH.name()) && !Objects.equals(lastDirection, Direction.Down.name())) {
            return Direction.Up.name();
        }
        return "";
    }

    public void damageHealth(int i) {
        this.health -= i;
    }
}
