
public class Person {
    private final String name;
    private final int age;
    private final int id;

    Person(String name, int age, int id){
        this.name = name;
        this.age = age;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}
