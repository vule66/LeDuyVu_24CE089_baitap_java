public class Main {
    public static void main(String[] args) {
        Circle c1 = new Circle(5.0, "Red");
        System.out.println("Circle Info: " + c1);
        System.out.println("Radius: " + c1.getRadius());
        System.out.println("Color: " + c1.getColor());
        System.out.println("Area: " + c1.getArea());

        Cylinder cy1 = new Cylinder(5.0, "Blue", 10.0);
        System.out.println("\nCylinder Info:");
        System.out.println("Base Circle: " + cy1.getBase());
        System.out.println("Height: " + cy1.getHeight());
        System.out.println("Volume: " + cy1.getVolume());
    }
}
