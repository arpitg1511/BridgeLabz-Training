package hospital_management_system;

public class Person {

    protected int id;
    protected String name;

    Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    int getId() {
        return id;
    }

    String getName() {
        return name;
    }
}
