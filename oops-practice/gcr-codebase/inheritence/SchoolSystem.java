import java.util.*;

// Base class representing a common Person in the school
class Person {

    String name;
    int age;

    // Constructor to initialize common person details
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Method to display the role of a person (to be overridden)
    void displayRole() {
        System.out.println("Person in School");
    }
}

// Teacher class inherits from Person
class Teacher extends Person {

    String subject;

    // Constructor initializes person and teacher-specific details
    public Teacher(String name, int age, String subject) {
        super(name, age); // initialize Person data
        this.subject = subject;
    }

    // Overridden method to display teacher role
    @Override
    void displayRole() {
        System.out.println("Role : Teacher");
        System.out.println("Subject : " + subject);
    }
}

// Student class inherits from Person
class Student extends Person {

    String grade;

    // Constructor initializes person and student-specific details
    public Student(String name, int age, String grade) {
        super(name, age); // initialize Person data
        this.grade = grade;
    }

    // Overridden method to display student role
    @Override
    void displayRole() {
        System.out.println("Role : Student");
        System.out.println("Grade : " + grade);
    }
}

// Staff class inherits from Person
class Staff extends Person {

    String department;

    // Constructor initializes person and staff-specific details
    public Staff(String name, int age, String department) {
        super(name, age); // initialize Person data
        this.department = department;
    }

    // Overridden method to display staff role
    @Override
    void displayRole() {
        System.out.println("Role : Staff");
        System.out.println("Department : " + department);
    }
}

public class SchoolSystem {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Creating different role objects using parent class reference
        Person teacher = new Teacher(sc.nextLine(), sc.nextInt(), sc.next());

        Person student = new Student(sc.nextLine(), sc.nextInt(), sc.next());

        Person staff = new Staff(sc.nextLine(), sc.nextInt(), sc.next());

        // Method calls resolved at runtime (Dynamic Method Dispatch)
        teacher.displayRole();
        student.displayRole();
        staff.displayRole();

        sc.close();
    }
}
