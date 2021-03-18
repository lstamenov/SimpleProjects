import java.util.List;

public class Faculty {
    private String name;
    private final int id;
    private List<Student> students;
    private List<Subject> subjects;
    private List<Teacher> teachers;
    double tax;

    public Faculty(String name, int id, List<Student> students, List<Subject> subjects, List<Teacher> teachers,double tax) {
        this.name = name;
        this.id = id;
        this.students = students;
        this.subjects = subjects;
        this.teachers = teachers;
        this.tax = tax;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public void listStudents(){
        for (Student s : getStudents()) {
            System.out.println(s.getInformation());
        }
    }

    public void addSubject(Subject subject){
        subjects.add(subject);
    }
}
