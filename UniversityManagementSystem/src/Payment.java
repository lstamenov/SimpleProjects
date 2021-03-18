public class Payment {
    private final Bank accountToReceive;
    private final Bank accountToPay;
    private final double quantity;

    public Payment(Bank accountToReceive, Bank accountToPay, double quantity) {
        this.accountToReceive = accountToReceive;
        this.accountToPay = accountToPay;
        this.quantity = quantity;
    }

    public void semesterTransaction(Student student){
        student.paySemester();
        accountToReceive.setBalance(accountToReceive.getBalance() + quantity);
        Payment payment = new Payment(accountToReceive, accountToPay, quantity);
        student.getStudentAccount().addTransaction(payment);
        accountToReceive.addTransaction(payment);
    }

    public void salaryTransaction(Teacher teacher){
        accountToReceive.setBalance(accountToReceive.getBalance() + quantity);
        accountToPay.setBalance(accountToPay.getBalance() - quantity);
        Payment payment = new Payment(accountToReceive, accountToPay, quantity);
        accountToPay.addTransaction(payment);
        accountToReceive.addTransaction(payment);
    }

    public Bank getAccountToPay() {
        return accountToPay;
    }

    public Bank getAccountToReceive() {
        return accountToReceive;
    }

    public double getQuantity() {
        return quantity;
    }
}
