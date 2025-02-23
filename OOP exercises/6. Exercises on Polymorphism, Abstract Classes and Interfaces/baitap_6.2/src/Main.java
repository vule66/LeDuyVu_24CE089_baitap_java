public class Main {
    public static void main(String[] args) {
        GeometricObject shape = new Circle(3.0);
        System.out.println(shape);
        System.out.println(shape.getArea());
        System.out.println(shape.getPerimeter());

        GeometricObject rectangle = new Rectangle(3.0, 3.0);
        System.out.println(rectangle);
        System.out.println(rectangle.getArea());
        System.out.println(rectangle.getPerimeter());
    }
}