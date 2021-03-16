import java.util.Random;

public class Bank {
    private double balance;
    private final int id;

    Bank(double balance){
        this.balance = balance;
        Random random = new Random(1000000000);
        this.id = random.nextInt();
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance){
        this.balance = balance;
    }

    public int getId() {
        return id;
    }
}
