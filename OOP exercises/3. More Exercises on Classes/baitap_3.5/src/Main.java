public class Main {
    public static void main(String[] args) {
        MyDate m1 = new MyDate(2024,10,31);
        System.out.println(m1);
        System.out.println(m1.getDay());
        System.out.println(m1.getMonth());
        System.out.println(m1.nextDay());
        System.out.println(m1.nextMonth());
        System.out.println(m1.getYear());
        m1.setDate(2021,10,5);
        System.out.println(m1);

        MyDate m2 = new MyDate(2024,12,1);
        System.out.println(m2);
        System.out.println(m2.previousDay());
        System.out.println(m2.previousMonth());
        System.out.println(m2.previousYear());

        MyDate m3 = new MyDate(2024,6,5);
        System.out.println(m3);
    }
}