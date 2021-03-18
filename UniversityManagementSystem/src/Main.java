import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ID id = new ID();
        id.increaseId();
        List<Student> students = new ArrayList<>();
        List<Faculty> faculties = new ArrayList<>();
        List<Subject> subjects = new ArrayList<>();
        List<Teacher> employees = new ArrayList<>();
        Faculty faculty = new Faculty("CS", id.getId(), students,subjects,employees , 400.00);
        Subject subject = new Subject("Java", id.getId(), employees);
        University sofiaUniversity = new University
                ("Sofia University", new Bank(id.getId(), 0.00),students, employees, faculties);
        sofiaUniversity.addFaculty(faculty);
        sofiaUniversity.getFaculties().get(0).addSubject(subject);
        sofiaUniversity.addStudent(new Student("Ivana Minova", 21, id.getId(), faculty, new Bank(id.getId(), 1000.00)));
        sofiaUniversity.addStudent(new Student("Lyubomir", 21, id.getId(), faculty, new Bank(id.getId(), 1000.00)));
        sofiaUniversity.getFaculties().get(0).addSubject(subject);
        for (Subject s : sofiaUniversity.getFaculties().get(0).getSubjects()) {
            for (Student student : sofiaUniversity.getFaculties().get(0).getStudents()) {
                student.doExam(s, 5);
            }
        }
        sofiaUniversity.getSemesterPaid();
    }
}
