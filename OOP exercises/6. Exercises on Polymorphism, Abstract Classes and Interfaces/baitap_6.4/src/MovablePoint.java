public class MovablePoint implements Movable {
    protected int x;
    protected int y;
    protected int xSpeed;
    protected int ySpeed;

    public MovablePoint(int x, int y, int xSpeed, int ySpeed) {
        this.x = x;
        this.y = y;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }
    public String toString() {
        return "(" + x + "," + y + "),speed=(" + xSpeed + "," + ySpeed + ")";
    }
    @Override
    public void moveUp() {
        y += ySpeed;
    }
    @Override
    public void moveDown() {
        y -= ySpeed;
    }
    @Override
    public void moveLeft() {
        x += xSpeed;
    }
    @Override
    public void moveRight() {
        x += xSpeed;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
}
