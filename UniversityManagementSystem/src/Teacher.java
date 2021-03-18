public class Teacher extends Person{
    private final Faculty faculty;
    private final Subject subject;
    private double salary;

    Teacher(String name, int age, int id, Faculty faculty, Subject subject){
        super(name, age, id);
        this.faculty = faculty;
        this.subject = subject;
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

}
