import java.util.ArrayList;
import java.util.List;

public class Bank {
    private final int id;
    private double balance;
    private List<Payment> payments = new ArrayList<>();

    public Bank(int id, double balance) {
        this.id = id;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void addMoney(double quantity){
        setBalance(getBalance() + quantity);
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void addTransaction(Payment payment){
        payments.add(payment);
        setPayments(payments);
    }

    public void showTransactions(){
        for (Payment payment : getPayments()) {
            System.out.printf("Quantity: %.2f%n" +
                    "   Sender ID: %d%n" +
                    "   Receiver ID: %d%n", payment.getQuantity(),
                    payment.getAccountToPay().getId(), payment.getAccountToReceive().getId());
        }
    }

}
