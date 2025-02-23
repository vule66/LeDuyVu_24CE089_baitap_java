public class Main {
    public static void main(String[] args) {
        MyPoint p1 = new MyPoint();
        MyPoint p2 = new MyPoint(2,4);
        MyPoint p3 = new MyPoint(5,3);
        MyLine m1 = new MyLine(p2,p3);
        MyLine m2 = new MyLine(2,1,4,5);
        System.out.println("line m1: "+m1);
        System.out.println("line m2: "+m2);
        System.out.println("begin m1: "+m1.getBegin());
        System.out.println("end m1: "+m1.getEnd());
        System.out.println("length: "+m1.getLength());
        System.out.println("gradient: "+m1.getGradient());
        m2.setBegin(p2);
        m2.setEnd(p2);
        m1.setEndXY(3,99);
        m1.setBeginXY(13,7);
        int[] beginXY = m1.getEndXY();
        System.out.println("beginXY: ("+ beginXY[0]+","+beginXY[1]+")");
        System.out.println(m1);

    }
}