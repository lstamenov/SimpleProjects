package CustomerInvoice;

public class Customer {
    private int id;
    private String name;
    private CustomerAccount customerAccount;

    Customer(int id, String name, CustomerAccount customerAccount){
        this.id = id;
        this.name = name;
        this.customerAccount = customerAccount;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public CustomerAccount getCustomerAccount() {
        return customerAccount;
    }
}
