package online_examination_system;

public class Student {

    private final int studentId;
    private String name;

    Student(int id, String name) {
        this.studentId = id;
        this.name = name;
    }

    int getId() {
        return studentId;
    }

    String getName() {
        return name;
    }
}
