public class Main {
    public static void main(String[] args) {
        Movable m1 = new MovablePoint(5,6,10,15);
        System.out.println(m1);
        m1.moveLeft();
        System.out.println(m1);

        Movable m2 = new MovableCircle(1,2,3,4, 20);
        System.out.println(m2);
        m2.moveRight();
        System.out.println(m2);

        Movable rectangle = new MovableRectangle(0, 0, 10, 10, 5, 5);
        System.out.println(rectangle); // Initial state
        rectangle.moveUp();
        rectangle.moveRight();
        System.out.println(rectangle); // After moving up and right
    }
}