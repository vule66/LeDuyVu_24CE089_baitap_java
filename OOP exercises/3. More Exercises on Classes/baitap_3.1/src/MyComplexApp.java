import java.util.Scanner;

public class MyComplexApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter complex number 1 (real and imaginary part): ");
        double r1 = sc.nextDouble(),r2 = sc.nextDouble();
        System.out.print("Enter complex number 2 (real and imaginary part): ");
        double r3 = sc.nextDouble(),r4 = sc.nextDouble();
        MyComplex s1 = new MyComplex(r1,r2);
        MyComplex s2 = new MyComplex(r3,r4);
        sc.close();
        System.out.println();
        System.out.print("Number 1 is: ("+s1.getReal()+"+"+s1.getImag()+"i)\n");
        System.out.println("("+s1.getReal()+"+"+s1.getImag()+"i) is " +
                (s1.isReal() ? "" : "NOT ") + "a pure real number");
        System.out.println("("+s1.getReal()+"+"+s1.getImag()+"i) is " +
                (s1.isImaginary() ? "" : "NOT ") + "a pure imaginary number");
        System.out.println();
        System.out.print("Number 2 is: ("+s2.getReal()+"+"+s2.getImag()+"i)\n");
        System.out.println("("+s2.getReal()+"+"+s2.getImag()+"i) is " +
                (s1.isReal() ? "" : "NOT ") + "a pure real number");
        System.out.println("("+s2.getReal()+"+"+s2.getImag()+"i) is " +
                (s1.isImaginary() ? "" : "NOT ") + "a pure imaginary number");
        System.out.println();
        System.out.println("("+s1.getReal()+"+"+s1.getImag()+"i) is " +
                (s1.equals(s2)? "":"NOT ")+"equals ("+s2.getReal()+"+"+s2.getImag()+"i)");
        System.out.println("("+s1.getReal()+"+"+s1.getImag()+"i) + " +
                "("+s2.getReal()+"+"+s2.getImag()+"i) = ("+s1.addNew(s2)+")");
    }
}
