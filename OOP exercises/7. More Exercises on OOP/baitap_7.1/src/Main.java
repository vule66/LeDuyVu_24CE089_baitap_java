import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer("Alice");
        customer.setMember(true);
        customer.setMemberType("Premium");

        Visit visit = new Visit(customer.getName(), new Date());
        visit.setServiceExpense(10);
        visit.setProductExpense(5);

        System.out.println(customer);
        System.out.println(visit);
        System.out.println("Total Expense after discounts: " + visit.getTotalExpense());

        Customer customer2 = new Customer("Bob");
        customer2.setMember(true);
        customer2.setMemberType("Gold");

        Visit visit2 = new Visit(customer2.getName(), new Date());
        visit2.setServiceExpense(20);
        visit2.setProductExpense(10);

        System.out.println(customer2);
        System.out.println(visit2);
        System.out.println("Total Expense after discounts: " + visit2.getTotalExpense());
    }
}
