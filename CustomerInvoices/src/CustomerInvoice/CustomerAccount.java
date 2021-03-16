package CustomerInvoice;

public class CustomerAccount {
    private final int id;
    Invoice invoice;
    private double balance;

    CustomerAccount(int id, double balance){
        this.id = id;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
        double oldBalance = getBalance();
        setBalance(oldBalance + invoice.getAmount());
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
