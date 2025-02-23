public class Main {
    public static void main(String[] args) {
        MyPolynomial p1 = new MyPolynomial(1.1, 2.2, 3.3);
        MyPolynomial p2 = new MyPolynomial(1.2, 3.4, 5.6, 7.8);

        System.out.println("p1: " + p1);
        System.out.println("p2: " + p2);
        System.out.println("Degree of p1: " + p1.getDegree());
        System.out.println("p1(2.0): " + p1.evaluate(2.0));
        System.out.println("p1 + p2: " + p1.add(p2));
        System.out.println("p1 * p2: " + p1.multiply(p2));
    }
}