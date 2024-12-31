import java.util.ArrayList;

public class SectionLogic {

    private ArrayList<Enemy> northWest;
    private ArrayList<Enemy> northEast;
    private ArrayList<Enemy> southWest;
    private ArrayList<Enemy> southEast;

    private int xMiddle;
    private int yMiddle;


    public SectionLogic() {

        xMiddle = 500;
        yMiddle = 400;
        this.southEast = new ArrayList<>();
        this.southWest = new ArrayList<>();
        this.northWest = new ArrayList<>();
        this.northEast = new ArrayList<>();
    }
 
    public void checkSectionState(Enemy enemy) {

        if (enemy.x < xMiddle && enemy.y < yMiddle) {
            if (!northWest.contains(enemy)) {
                northWest.add(enemy);
                northEast.remove(enemy);
                southEast.remove(enemy);
                southWest.remove(enemy);
            }
        } else if (enemy.x > xMiddle && enemy.y < yMiddle) {
            if (!northEast.contains(enemy)) {
                northEast.add(enemy);
                northWest.remove(enemy);
                southEast.remove(enemy);
                southWest.remove(enemy);
            }
        } else if (enemy.x < xMiddle && enemy.y > yMiddle) {
            if (!southEast.contains(enemy)) {
                southEast.add(enemy);
                southWest.remove(enemy);
                northWest.remove(enemy);
                northEast.remove(enemy);
            }
        } else if(enemy.x > xMiddle && enemy.y > yMiddle) {
            if (!southWest.contains(enemy)) {
                southWest.add(enemy);
                southEast.remove(enemy);
                northWest.remove(enemy);
                northEast.remove(enemy);
            }
        }
    }

    public Sections checkSectionState (int x, int y) {
        if (x < xMiddle && y < yMiddle) {
                return Sections.NORTHWEST;
        } else if (x > xMiddle && y < yMiddle) {
            return Sections.NORTHEAST;
        } else if (x < xMiddle && y > yMiddle) {
            return Sections.SOUTHEAST;
        } else if(x > xMiddle && y > yMiddle) {
            return Sections.SOUTHWEST;
        }
        return Sections.NORTHEAST;
    }

    public ArrayList<Enemy> getNorthWest() {
        return northWest;
    }

    public ArrayList<Enemy> getNorthEast() {
        return northEast;
    }

    public ArrayList<Enemy> getSouthWest() {
        return southWest;
    }

    public ArrayList<Enemy> getSouthEast() {
        return southEast;
    }
}
