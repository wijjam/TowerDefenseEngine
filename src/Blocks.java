public class Blocks {

    private Ground ground;
    private int x;
    private int y;


    public Blocks(int x, int y, Ground ground) {
        this.x = x;
        this.y = y;
        this.ground = ground;}

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Ground getGround() {
        return ground;
    }

    public void setGround(Ground ground) {
        this.ground = ground;
    }
}
