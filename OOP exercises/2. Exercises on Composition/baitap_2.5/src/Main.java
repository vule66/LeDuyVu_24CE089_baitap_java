
public class Main {
    public static void main(String[] args) {
        // Tạo một khách hàng
        Customer customer = new Customer(1001, "Alice", 'F');
        System.out.println(customer);  // Kiểm tra toString()

        // Tạo một tài khoản ngân hàng cho khách hàng
        Account account = new Account(2001, customer, 500.0);
        System.out.println(account);  // Kiểm tra toString()

        // Thử gửi tiền vào tài khoản
        account.deposit(200.0);
        System.out.println("After deposit: " + account);

        // Thử rút tiền hợp lệ
        account.withdraw(100.0);
        System.out.println("After withdrawal: " + account);

        // Thử rút số tiền lớn hơn số dư (không hợp lệ)
        account.withdraw(700.0);
        System.out.println("After failed withdrawal: " + account);
    }
}