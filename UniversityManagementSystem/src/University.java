import java.util.List;

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
}
