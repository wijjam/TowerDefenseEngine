import java.util.ArrayList;
import java.util.Random;

public class PlacedTowers {


    int x, y;
    private Ground ground;
    private String towerName;
    private int towerDamage;
    private int cooldownTime;
    private long lastShotTime;
    private Random random;
    private ArrayList<Enemy> enemies;
    private ArrayList<Enemy> deadEnemies;
    private int coins;
    private SideMenu sideMenu;
    private Sections sections;




    public PlacedTowers(int x, int y, Ground ground, String towerName, SideMenu sideMenu, Sections sections){
        this.x = x;
        this.y = y;
        this.ground = ground;
        this.towerName = towerName;
        this.towerDamage = 100;
        this.lastShotTime = 0;
        this.cooldownTime = 200;
        random = new Random();
        deadEnemies = new ArrayList<>();
        coins = 0;
        this.sideMenu = sideMenu;
        this.sections = sections;
    }

    // Method to check if the tower can shoot
    public boolean canShoot() {
        long currentTime = System.currentTimeMillis();
        if (currentTime - lastShotTime >= cooldownTime) {
            System.out.println("Can shoot");
            lastShotTime = currentTime; // Reset last shot time
            return true;
        }
        return false;
    }

    public void checkIfHit(ArrayList<Enemy> enemies) {
        coins = 0;
        for (Enemy enemy: enemies) {
            if (enemy.x <= (this.x * StateValues.BLOCKMARGIN) + StateValues.BLOCKMARGIN && enemy.x >= (this.x * StateValues.BLOCKMARGIN) - StateValues.BLOCKMARGIN) {
                if (enemy.y <= (this.y * StateValues.BLOCKMARGIN) + StateValues.BLOCKMARGIN && enemy.y >= (this.y * StateValues.BLOCKMARGIN) - StateValues.BLOCKMARGIN) {
                    if (this.canShoot()) {
                        if (random.nextInt(100) >= 50) {
                            System.out.println(" ");
                        } else {
                            System.out.println("Enemy total size: " + enemies.size());
                            enemy.damageHealth(100);
                            deadEnemies.add(enemy);
                            sideMenu.updateCoinCounter(5);
                            System.out.println(sideMenu.getCoins());
                        }
                    }
                }
            }
        }
        if (!deadEnemies.isEmpty()) {
            for (Enemy deadEnemy : deadEnemies) {
                enemies.remove(deadEnemy);
            }
        }
    }


    public int getCoins() {
        return coins;
    }

    // This method returns the damage the tower generates against an enemy.
    public int getAttackDamage() {
        return towerDamage;
    }

    public Sections getSections() {
        return sections;
    }
}

