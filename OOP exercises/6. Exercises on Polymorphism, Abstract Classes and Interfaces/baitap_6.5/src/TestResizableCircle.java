public class TestResizableCircle {
    public static void main(String[] args) {
        ResizableCircle r1 = new ResizableCircle(1.0);
        System.out.println(r1);
        System.out.println(r1.radius);
        System.out.println(r1.resize(50));
        System.out.println(r1.getArea());
        System.out.println(r1.getPerimeter());
    }
}
