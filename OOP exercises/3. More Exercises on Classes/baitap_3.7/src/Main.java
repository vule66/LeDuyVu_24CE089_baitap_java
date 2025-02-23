//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Ball ball = new Ball(50.0f, 50.0f, 5.0f);
        Player p = new Player(6, 5.0f, 5.0f);
        System.out.println("Initial ball position: " + ball);
        System.out.println("Initial player position: " + p);

        p.move(45.0f,45.f);
        System.out.println("Player moved to : " + p);
        if(p.near(ball)){
            p.kick(ball);
            System.out.println("Ball kicked!: " + ball);
        }
        else{
            System.out.println("Player " + p.getNumber() + " is not close enough to the ball to kick it." );
        }
    }
}