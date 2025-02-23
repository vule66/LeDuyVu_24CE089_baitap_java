public class Cylinder {
    private Circle base;
    private double height;

    public Cylinder(double radius, String color, double height) {
        this.base = new Circle(radius, color);
        this.height = 1.0;
    }
    public Circle getBase() {
        return base;
    }

    public void setBase(Circle base) {
        this.base = base;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getVolume() {
        return base.getArea() * height;
    }
}
