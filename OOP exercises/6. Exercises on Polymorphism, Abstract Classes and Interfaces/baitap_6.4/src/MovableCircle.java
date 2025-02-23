public class MovableCircle implements Movable {
    private int radius;
    private MovablePoint center;

    public MovableCircle(int x, int y, int xSpeed, int ySpeed, int radius) {
        this.radius = radius;
        this.center = new MovablePoint(x, y, xSpeed, ySpeed);
    }
    @Override
    public void moveUp() {
        center.moveUp();
    }
    @Override
    public void moveDown() {
        center.moveDown();
    }

    @Override
    public void moveLeft() {
        center.moveLeft();
    }

    @Override
    public void moveRight() {
        center.moveRight();
    }

    public int getRadius() {
        return radius;
    }

    public int getX() {
        return center.getX();
    }

    public int getY() {
        return center.getY();
    }

    public String toString() {
        return "(" + center.getX() + "," + center.getY() + "), speed=(" + center.getX() + "," + center.getY() + "), radius=" + radius;
    }
}
