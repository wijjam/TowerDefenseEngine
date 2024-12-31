import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class TowerLogic extends JPanel implements MouseListener {

    private ArrayList<Blocks> blocks;
    private GameBoard gameBoard;
    private ArrayList<PlacedTowers> towers;
    private PlacedTowers tower;
    private boolean canPlaceTower;
    private int towerDimensionWidth, towerDimensionHeight;
    private int towerXIndex, towerYIndex;
    private String towerName;
    private boolean boughtTower;
    private SideMenu sideMenu;
    private BufferedImage image;
    public TowerLogic(GameBoard gameBoard, ArrayList<Blocks> blocks, ArrayList<PlacedTowers> towers, SideMenu sideMenu, BufferedImage image) {

        this.towers = towers;
        this.gameBoard = gameBoard;
        gameBoard.addMouseListener(this);
        setVisible(false);
        this.blocks = blocks;
        this.canPlaceTower = true;
        towerDimensionWidth = 25;
        towerDimensionHeight = 25;
        towerName = "";
        boughtTower = true;
        this.sideMenu = sideMenu;
        this.image = image;
    }


    // this method gets the dimensions of where the mouse clicked and then scans the nearest grid to see if we can place a tower object on it.
    private void placeBlock(int x, int y) {
        // We use these two variables to find the nearest grid to where the mouse button was pressed.
        towerXIndex = (int) Math.round(x / (double) StateValues.BLOCKMARGIN);
        towerYIndex = (int) Math.round(y / (double) StateValues.BLOCKMARGIN);
        // this if statement checks if the Timer has activated and turned canPlaceTower to true or if it is still false after the latest tower placed.
        if (canPlaceTower) {
            Graphics2D g2d = (Graphics2D) gameBoard.getGraphics();
            // In this for loop we iterate through the blocks ArrayList that contains all blocks in the map. With each iteration we check for block types.
            for (int i = 0; i < blocks.size(); i++) {
                if (blocks.get(i).getX() == towerXIndex && blocks.get(i).getY() == towerYIndex) {
                    // We use the block types in this if statement to check if it is a valid spot to place a tower or not.
                    if (!boughtTower || blocks.get(i).getGround() == Ground.PATH || blocks.get(i).getGround() == Ground.TOWER || blocks.get(i).getGround() == Ground.END || blocks.get(i).getGround() == Ground.START) {
                        // This section is run if we find that we can not place a tower on the current grid tile.
                    } else {
                        // If we can place a block we print out a debug message of the current block index where the tower is placed.
                        // We then change the color to red and draw a red rectangle on the current grid tile.
                        // It is then placed in a towers ArrayList so we can redraw it when the GUI updates.
                        // We then change the current block in the blocks to say tower so it can not place duplicates.
                        // Lastly we start the cool down timer which ensures less bugs and a more playable experience.
                        // Then we break the loop ensuring once again that there is no duplicates created on the same tile.
                        System.out.println(i);
                        g2d.drawImage(image,towerXIndex * StateValues.BLOCKMARGIN, towerYIndex * StateValues.BLOCKMARGIN, this);
                        tower = new PlacedTowers(towerXIndex, towerYIndex, blocks.get(i).getGround(), towerName, sideMenu, new SectionLogic().checkSectionState(towerXIndex * 50, towerYIndex * 50));
                        towers.add(tower);
                        blocks.get(i).setGround(Ground.TOWER);
                        canPlaceTower = false;
                        boughtTower = false;
                        startCooldownTimer();
                        break;

                    }
                }
            }
        }
    }

    public void setTowerName(String towerName) {
        this.towerName = towerName;
        this.boughtTower = true;
    }

    // This method starts the timer that controls the delay for the tower placement.
    private void startCooldownTimer() {
        new Timer(500, e -> canPlaceTower = true).start();
    }

    // This method is used to take in a mouse clicked action and then from that get it's x and y coordinates.
    // It then sends the coordinates to placeBlocks method to calculate if a block can be placed and how to create it.
    @Override
    public void mouseClicked(MouseEvent e) {
        placeBlock(e.getX() -StateValues.BLOCKMARGIN/2, e.getY() -StateValues.BLOCKMARGIN/2);
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
