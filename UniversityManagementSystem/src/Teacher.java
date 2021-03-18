public class Teacher extends Person {
    private final Faculty faculty;
    private final Subject subject;
    private Bank account;
    private double salary;

    Teacher(String name, int age, int id, Faculty faculty, Subject subject, Bank account) {
        super(name, age, id);
        this.faculty = faculty;
        this.subject = subject;
        this.account = account;
        this.salary = faculty.getTax() * 3;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public Subject getSubject() {
        return subject;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Bank getAccount() {
        return account;
    }
    public void setAccount(Bank account){
        this.account = account;
    }
}