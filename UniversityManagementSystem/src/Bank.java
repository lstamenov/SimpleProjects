public class Bank {
    int id;
    double balance;

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

    //method for money transfer
    public void setBalance(double balance) {
        this.balance = balance;
    }
}
