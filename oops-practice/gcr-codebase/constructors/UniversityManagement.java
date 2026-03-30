import java.util.*;

// Superclass
class Student {
    public int rollNumber;       // public: accessible everywhere
    protected String name;       // protected: accessible in subclass
    private double CGPA;         // private: accessible only in this class

    // Parameterized constructor
    public Student(int rollNumber, String name, double CGPA) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.CGPA = CGPA;
    }

    // Public getter for CGPA
    public double getCGPA() {
        return CGPA;
    }

    // Public setter for CGPA
    public void setCGPA(double CGPA) {
        if(CGPA >= 0 && CGPA <= 10)
            this.CGPA = CGPA;
        else
            System.out.println("Invalid CGPA! Must be between 0 and 10.");
    }

    // Method to display student details
    public void displayStudentDetails() {
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Name: " + name);
        System.out.println("CGPA: " + CGPA);
    }
}

// Subclass demonstrating protected member access
class PostgraduateStudent extends Student {

    private String researchTopic;

    public PostgraduateStudent(int rollNumber, String name, double CGPA, String researchTopic) {
        super(rollNumber, name, CGPA); // call superclass constructor
        this.researchTopic = researchTopic;
    }

    public void displayPostgraduateDetails() {
        // Can access protected member 'name' directly
        System.out.println("Postgraduate Student Name: " + name);
        System.out.println("Research Topic: " + researchTopic);
        System.out.println("CGPA: " + getCGPA()); // private accessed via public method
    }
}

public class UniversityManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input for Student
        System.out.println("Enter roll number, name, and CGPA for student:");
        int roll = sc.nextInt();
        sc.nextLine(); // consume newline
        String name = sc.nextLine();
        double cgpa = sc.nextDouble();
        sc.nextLine(); // consume newline

        Student s1 = new Student(roll, name, cgpa);
        s1.displayStudentDetails();

        // Input for PostgraduateStudent
        System.out.println("\nEnter roll number, name, CGPA, and research topic for postgraduate student:");
        int pgRoll = sc.nextInt();
        sc.nextLine(); // consume newline
        String pgName = sc.nextLine();
        double pgCGPA = sc.nextDouble();
        sc.nextLine(); // consume newline
        String topic = sc.nextLine();

        PostgraduateStudent pgStudent = new PostgraduateStudent(pgRoll, pgName, pgCGPA, topic);
        pgStudent.displayPostgraduateDetails();

        sc.close();
    }
}
