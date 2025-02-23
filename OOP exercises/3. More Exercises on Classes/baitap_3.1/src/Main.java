//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        MyComplex s1 = new MyComplex(3.4,4.4);
        MyComplex s2 = new MyComplex(3.4,4.5);
        System.out.println("Real: "+s1.getReal());
        System.out.println("Imag: "+s1.getImag());
        System.out.println("("+s1.getReal()+"+"+s1.getImag()+"i) is " +
                (s1.isReal() ? "" : "NOT ") + "a pure real number");
        System.out.println("("+s1.getReal()+"+"+s1.getImag()+") is " +
                (s1.isImaginary() ? "" : "NOT ") + "a pure imaginary number");
        System.out.printf("magniture: %.1f%n",s1.magnitude());
        System.out.println("("+s1.getReal()+"+"+s1.getImag()+"i) is " +
                (s1.equals(s2)? "":"NOT ")+"equals ("+s2.getReal()+"+"+s2.getImag()+"i)");
        System.out.println("("+s1.getReal()+"+"+s1.getImag()+"i) + " +
                "("+s2.getReal()+"+"+s2.getImag()+"i) = ("+s1.addNew(s2)+")");
    }
}