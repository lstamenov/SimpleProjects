import java.util.List;
import java.util.Map;

class Student extends Person{
    private final Faculty faculty;
    private final List<Subject> subjects;
    private Map<Subject, Integer> grades;

    Student(String name, int age, int id, Faculty faculty,
            List<Subject> subjects, Map<Subject, Integer> grades){
        super(name, age, id);
        this.faculty = faculty;
        this.subjects = subjects;
        this.grades = grades;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public Map<Subject, Integer> getGrades() {
        return grades;
    }

    public void setGrades(Map<Subject, Integer> grades) {
        this.grades = grades;
    }
}