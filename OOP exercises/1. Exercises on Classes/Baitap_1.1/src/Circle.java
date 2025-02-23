public class Circle {
    private double radius;
    private String color;

    public Circle(){
        radius = 1.0;
        color = "red";
    }

    public Circle(double r){
        radius = r;
        color = "red";
    }
    public Circle(double r, String c){
        radius = r;
        color = c;
    }
    public double getRadius(){
        return radius;
    }
    public String getColor(){
        return color;
    }
    public void setRadius(double newRadius){
        this.radius = newRadius;
    }
    public void setColor(String newColor){
        this.color = newColor;
    }
    public String toString(){
        return "Circle[radius=" + radius + ", color=" + color + "]";
    }
    public double getArea(){
        return Math.PI * radius * radius;
    }
}
