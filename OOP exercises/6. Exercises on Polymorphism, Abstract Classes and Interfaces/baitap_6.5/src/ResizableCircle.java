public class ResizableCircle extends Circle implements Resizable {
    public ResizableCircle(double radius) {

        super(radius);
    }
    public String toStirng() {

        return "ResizableCircle[" + super.toString() + "]";
    }
    @Override
    public double resize(int percent) {
        radius *= (1 + (double)percent / 100);
        return percent;
    }
}
