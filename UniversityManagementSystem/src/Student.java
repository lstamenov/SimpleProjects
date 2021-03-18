import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

class Student extends Person{
    private final Faculty faculty;
    private final List<Subject> subjects;
    private Map<Subject, Integer> grades;
    private boolean isSemesterPaid = false;
    private Bank studentAccount;
    Student(String name, int age, int id, Faculty faculty, Bank studentAccount){
        super(name, age, id);
        this.faculty = faculty;
        this.subjects = faculty.getSubjects();
        this.grades = new LinkedHashMap<>();
        this.studentAccount = studentAccount;
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

    public void setSemesterPaid(boolean semesterPaid) {
        isSemesterPaid = semesterPaid;
    }

    public boolean isSemesterPaid() {
        return isSemesterPaid;
    }

    public Bank getStudentAccount() {
        return studentAccount;
    }

    public void paySemester(){
        studentAccount.setBalance(studentAccount.getBalance() - faculty.getTax());
        setSemesterPaid(true);
    }

    public void doExam(Subject subject, int grade){
        grades.put(subject, grade);
    }

    public String getInformation(){
        return String.format("Name: %s, Age: %d, StudentID: %d%n" +
                "   Faculty: %s%n" +
                "   Paid semester: %b%n", getName(), getAge(), getId(), getFaculty().getName(), isSemesterPaid);
    }

    public void getGradesInformation(){
        String inf = String.format("Name: %s, StudentID: %d, Faculty: %s%n",getName(), getId(), getFaculty().getName());
        System.out.println(inf);
        for (Map.Entry<Subject, Integer> grade : grades.entrySet()) {
            System.out.printf("Subject: %s -> Grade: %d", grade.getKey(), grade.getValue());
        }
    }
}