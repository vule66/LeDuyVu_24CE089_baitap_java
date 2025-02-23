public class Account {
    private int id;
    private Customer customer;
    private double balance;
    public Account(int id,Customer customer){
        this.id=id;
        this.customer=customer;
        this.balance=0.0;
    }
    public Account(int id,Customer customer,double balance){
        this.id=id;
        this.customer=customer;
        this.balance=balance;
    }

    public int getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    public String getCustomerNAme(){
        return customer.getName();
    }
    public Account deposit(double amount){
        balance+=amount;
        return this;
    }
    public Account withdraw(double amount){
        if(balance>=amount) {
            balance -= amount;
        }
        else{
            System.out.println("amount withdraw exceeds the current balancel!");
        }
            return this;
    }

    @Override
    public String toString() {
        return getCustomerNAme()+"("+id+") "+"Balance"+balance;
    }
}

