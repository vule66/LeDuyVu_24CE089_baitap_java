public class Main {
    public static void main(String[] args) {
        Circle c1 = new Circle();
        System.out.println("The circle has radius of" + c1.getRadius() + " and area of " + c1.getArea());
        Circle c2 = new Circle(2.0);
        System.out.println("The circle has a radius of " + c2.getRadius() + " and area of " + c2.getArea());

        /* Circle c3 = new Circle();
        System.out.println(c1.radius=5.0); */

        Circle c4 = new Circle();
        c4.setRadius(5.5);
        System.out.println("radius is: " + c4.getRadius());
        c4.setColor("green");
        System.out.println("color is: " + c4.getColor());

        /* System.out.println(c4.setRadius(4.4)); */

        Circle c5 = new Circle(5.5);
        System.out.println(c5.toString());

        Circle c6 = new Circle(6.6);
        System.out.println(c6.toString());
        System.out.println(c6);
        System.out.println("Operator '+' invokes toString() too:" + c6);


    }
}