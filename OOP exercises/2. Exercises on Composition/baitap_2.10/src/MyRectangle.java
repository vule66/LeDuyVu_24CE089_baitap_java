public class MyRectangle {
    private MyPoint topLeft;
    private MyPoint bottomRight;

    public MyRectangle(MyPoint topLeft, MyPoint bottomRight) {
        this.topLeft = topLeft;
        this.bottomRight = bottomRight;
    }
    public MyPoint getTopLeft() {

        return topLeft;
    }
    public void setTopLeft(MyPoint topLeft) {

        this.topLeft = topLeft;
    }
    public MyPoint getBottomRight() {

        return bottomRight;
    }
    public void setBottomRight(MyPoint bottomRight) {

        this.bottomRight = bottomRight;
    }
    public int getWidth() {

        return Math.abs(bottomRight.getX() - topLeft.getX());
    }
    public int getHeight() {

        return Math.abs(topLeft.getY() - bottomRight.getY());
    }
    public int getArea(){

        return getWidth() * getHeight();
    }
    public int getPerimeter(){

        return 2 * (getWidth() + getHeight());
    }
    public String toString(){
        return "MyRectangle [topLeft=" + topLeft + ", bottomRight=" + bottomRight + ", width=" + getWidth() + ", height=" + getHeight() + ", area=" + getArea() + ", perimeter=" + getPerimeter() + "]";
    }
}
