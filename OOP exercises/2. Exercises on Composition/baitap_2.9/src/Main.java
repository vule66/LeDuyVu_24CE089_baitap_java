//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        MyTriangle t1 = new MyTriangle(1,2,3,4,5,6);
        System.out.println("t1= "+t1);
        MyPoint p1 = new MyPoint(3,4);
        MyPoint p2 = new MyPoint();
        MyPoint p3 =new MyPoint(4,2);
        MyTriangle t2 = new MyTriangle(p1,p2,p3);
        System.out.println("t2= "+t2);
        System.out.printf("t2 Perimeter= %.2f%n",t2.getPerimeter());
        System.out.println("t2 type= "+t2.getType());
    }
}