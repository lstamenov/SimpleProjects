import java.util.List;

public class Subject {
    String name;
    int id;
    List<Teacher> teachers;

    public Subject(String name, int id, List<Teacher> teachers) {
        this.name = name;
        this.id = id;
        this.teachers = teachers;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }
}
