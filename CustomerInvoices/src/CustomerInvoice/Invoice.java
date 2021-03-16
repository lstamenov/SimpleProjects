package CustomerInvoice;

public class Invoice {
    private final int id;
    private final Customer customer;
    private final double amount;
    private CustomerAccount customerAccount;


    Invoice(int id, Customer customer, double amount){
        this.id = id;
        this.customer = customer;
        this.amount = amount;
        customer.getCustomerAccount().setBalance(customer.getCustomerAccount().getBalance() + amount);
    }

    public Customer getCustomer() {
        return customer;
    }

    public int getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public void addToBalance(Customer customer, double amount){
        double oldCustomerBalance = customer.getCustomerAccount().getBalance();
        System.out.println("Before transaction: " + oldCustomerBalance);
        getCustomer().getCustomerAccount().setBalance(oldCustomerBalance + amount);
    }
}
