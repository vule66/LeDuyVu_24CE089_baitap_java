public class Main {
    public static void main(String[] args) {

        MyCircle c1 = new MyCircle();
        System.out.println("c1: " + c1);


        MyCircle c2 = new MyCircle(5, 7, 10);
        System.out.println("c2: " + c2);


        MyPoint point = new MyPoint(2, 3);
        MyCircle c3 = new MyCircle(point, 4);
        System.out.println("c3: " + c3);


        System.out.println("c2 radius: " + c2.getRadius());
        c2.setRadius(15);
        System.out.println("c2 updated radius: " + c2.getRadius());


        System.out.println("c3 center: " + c3.getCenter());
        c3.setCenter(new MyPoint(8, 8));
        System.out.println("c3 updated center: " + c3.getCenter());


        System.out.println("c2 center X: " + c2.getCenterX());
        System.out.println("c2 center Y: " + c2.getCenterY());
        c2.setCenterX(9);
        c2.setCenterY(6);
        System.out.println("c2 updated center: " + c2.getCenter());


        int[] centerXY = c1.getCenterXY();
        System.out.println("c1 center XY: (" + centerXY[0] + ", " + centerXY[1] + ")");
        c1.setCenterXY(4, 4);
        System.out.println("c1 updated center: " + c1.getCenter());


        System.out.printf("c2 area: %.2f%n", c2.getArea());
        System.out.printf("c2 circumference: %.2f%n", c2.getCircumference());


        System.out.printf("Distance between c1 and c2: %.2f%n", c1.distance(c2));
        System.out.printf("Distance between c2 and c3: %.2f%n", c2.distance(c3));
    }
}