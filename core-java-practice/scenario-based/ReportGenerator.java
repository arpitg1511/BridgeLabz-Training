import java.util.*;

// custom exception
class InvalidMarkException extends Exception {

    InvalidMarkException(String message) {
        super(message);
    }
}

// Student class
class Student {

    private int studentId;
    private String name;
    private String[] subjects;
    private int[] marks;

    Student(int studentId, String name, String[] subjects, int[] marks)
            throws InvalidMarkException {

        this.studentId = studentId;
        this.name = name;
        this.subjects = subjects;
        this.marks = marks;

        validateMarks();
    }

    // validate marks
    private void validateMarks() throws InvalidMarkException {
        for (int mark : marks) {
            if (mark < 0 || mark > 100) {
                throw new InvalidMarkException("Marks must be between 0 and 100");
            }
        }
    }

    // calculate average
    double calculateAverage() {
        int sum = 0;
        for (int mark : marks) {
            sum += mark;
        }
        return sum / (double) marks.length;
    }

    // assign grade
    String getGrade() {
        double avg = calculateAverage();

        if (avg >= 80) return "A";
        if (avg >= 60) return "B";
        if (avg >= 40) return "C";
        return "F";
    }

    // display report card
    void displayReport() {
        System.out.println("----------------------------------");
        System.out.println("Student ID   : " + studentId);
        System.out.println("Student Name : " + name);
        System.out.println("Subjects & Marks:");

        for (int i = 0; i < subjects.length; i++) {
            System.out.printf("  %-10s : %d%n", subjects[i], marks[i]);
        }

        System.out.printf("Average Marks: %.2f%n", calculateAverage());
        System.out.println("Grade        : " + getGrade());
        System.out.println("----------------------------------");
    }
}

// main class
public class ReportGenerator {

    public static void main(String[] args) {

        List<Student> students = new ArrayList<>();

        String[] subjects = {"Maths", "Physics", "Chemistry"};

        try {
            students.add(new Student(
                    101,
                    "Amit",
                    subjects,
                    new int[]{85, 78, 90}
            ));

            students.add(new Student(
                    102,
                    "Neha",
                    subjects,
                    new int[]{65, 70, 60}
            ));

            // invalid marks example
            students.add(new Student(
                    103,
                    "Rahul",
                    subjects,
                    new int[]{95, 110, 80}
            ));

        } catch (InvalidMarkException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // display all student reports
        for (Student s : students) {
            s.displayReport();
        }
    }
}
