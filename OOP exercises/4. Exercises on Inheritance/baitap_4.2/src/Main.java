public class Main {
    public static void main(String[] args) {
        Student s1 = new Student("Vu", "QN", "CE", 2024, 9);
        Staff t1 = new Staff("Duy", "HN", "VKU", 99999);
        System.out.println(s1);
        System.out.println(t1);

        s1.setProgram("CE");
        System.out.println(s1.getProgram());
    }
}