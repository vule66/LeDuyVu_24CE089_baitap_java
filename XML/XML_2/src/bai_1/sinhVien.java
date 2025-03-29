package bai_1;

import java.util.Scanner;

public class sinhVien {
    private String id;
    private String name;
    private int age;
    private String major;

    public sinhVien() {
    }

    public sinhVien(String id, String name, String major, int age){
       this.id=id;
       this.name=name;
       this.age=age;
       this.major=major;
    }

    public void input(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter id student: ");
        id = scanner.nextLine();
        System.out.println("Enter name: ");
        name = scanner.nextLine();
        System.out.println("Enter age: ");
        age = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter major: ");
        major = scanner.nextLine();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getMajor() {
        return major;
    }

    public int getAge() {
        return age;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    @Override
    public String toString() {
        return
                "       <student id=\""+id+"\">\n" +
                        "        <name>"+name+"</name>\n" +
                        "        <age>"+age+"</age>\n" +
                        "        <major>"+major+"</major>\n" +
                        "    </student>\n"

        ;
    }
}
