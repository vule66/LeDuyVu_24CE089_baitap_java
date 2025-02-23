public class Player {
    private int number;
    private float x;
    private float y;
    private float z = 0.0f;

    public Player(int number, float x, float y) {
        this.number = number;
        this.x = x;
        this.y = y;
    }
    public int getNumber() {
        return number;
    }
    public void move(float xDisp, float yDisp) {
        this.x += xDisp;
        this.y += yDisp;
    }
    public Boolean near(Ball ball){
        double distance;
        distance = Math.sqrt(Math.pow(-(ball.getX() - this.x), 2) + Math.pow(-(ball.getY() - this.y), 2));
        if(distance < 8){
            return true;
        }
        return false;
    }
    public void kick(Ball ball) {
        float xDirection = ball.getX() - x;
        float yDirection = ball.getY() - y;
        ball.setXYZ(ball.getX() + xDirection * 2, ball.getY() + yDirection * 2, ball.getZ());
    }
    public String toString() {
        return "(" + number + "," + x + "," + y + ")";
    }
}
