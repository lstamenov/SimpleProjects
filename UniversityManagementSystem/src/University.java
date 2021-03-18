import java.util.List;
import java.util.Scanner;

public class University {
    private final String name;
    private Bank account;
    private List<Student> students;
    private List<Teacher> employees;
    private List<Faculty> faculties;

    University(String name, Bank account, List<Student> students,
               List<Teacher> employees, List<Faculty> faculties){
        this.name = name;
        this.account = account;
        this.students = students;
        this.employees = employees;
        this.faculties = faculties;
    }

    public String getName() {
        return name;
    }

    public Bank getAccount() {
        return account;
    }

    public void setAccount(Bank account) {
        this.account = account;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Teacher> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Teacher> employees) {
        this.employees = employees;
    }

    public List<Faculty> getFaculties() {
        return faculties;
    }

    public void setFaculties(List<Faculty> faculties) {
        this.faculties = faculties;
    }

    public void addStudent(Student student){
        if (student.getFaculty().getTax() < student.getStudentAccount().getBalance()) {
            Payment payment = new Payment(account, student.getStudentAccount(), student.getFaculty().getTax());
            payment.semesterTransaction(student);
            students.add(student);
        }else {
            System.out.println("Student: %s does not have enough money to pay!");
        }
    }

    public void expelStudent(Student student){
        getStudents().remove(student);
    }

    public void getSemesterPaid(){
        for (Student s : getStudents()) {
            if (s.getStudentAccount().getBalance() < s.getFaculty().getTax()){
                System.out.printf("Student: %s does not have enough money to pay!",s.getName());
                System.out.println("Add money?: Yes or No");
                Scanner scanner = new Scanner(System.in);
                String des = scanner.nextLine();
                if (des.equals("Yes")){
                    System.out.println("How much money would you like to add?");
                    double quantity = Double.parseDouble(scanner.nextLine());
                    s.getStudentAccount().addMoney(quantity);
                    Payment payment = new Payment(account, s.getStudentAccount(), s.getFaculty().getTax());
                    payment.semesterTransaction(s);
                }else {
                    System.out.println(s.getInformation() + "Has been expelled!");
                }
            }else {
                Payment payment = new Payment(account, s.getStudentAccount(), s.getFaculty().getTax());
                payment.semesterTransaction(s);
            }
        }
    }

    public void sendSalaries(){
        for (Teacher e : employees) {
            Payment payment = new Payment(e.getAccount(), account, e.getSalary());
            payment.salaryTransaction(e);
        }
    }

    public void riseSalary(Teacher teacher,double rise){
        teacher.setSalary(teacher.getSalary() + rise);
    }

    public void addFaculty(Faculty faculty){
        faculties.add(faculty);
    }
}
