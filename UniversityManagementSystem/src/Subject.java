import java.util.LinkedHashMap;

public class Subject {
    String name;
    int id;
    Teacher teacher;
    LinkedHashMap<Student, Integer> grades;

    public Subject(String name, int id, Teacher teacher, LinkedHashMap<Student, Integer> grades) {
        this.name = name;
        this.id = id;
        this.teacher = teacher;
        this.grades = grades;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    //method to change Teacher
    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    //method to add student and its grade
    public LinkedHashMap<Student, Integer> getGrades() {
        return grades;
    }

    public void setGrades(LinkedHashMap<Student, Integer> grades) {
        this.grades = grades;
    }
}
