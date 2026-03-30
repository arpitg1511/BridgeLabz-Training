import java.util.*;

public class Course {

    // Instance variables
    private String courseName;
    private int duration; // in weeks
    private double fee;

    // Class variable (shared among all courses)
    private static String instituteName = "ABC Institute";

    // Parameterized constructor
    public Course(String courseName, int duration, double fee) {
        this.courseName = courseName;
        this.duration = duration;
        this.fee = fee;
    }

    // Instance method to display course details
    public void displayCourseDetails() {
        System.out.println("Course Name: " + courseName);
        System.out.println("Duration (weeks): " + duration);
        System.out.printf("Fee: %.2f\n", fee);
        System.out.println("Institute: " + instituteName);
    }

    // Class method to update institute name
    public static void updateInstituteName(String newInstituteName) {
        instituteName = newInstituteName;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input first course
        String name1 = sc.nextLine();
        int duration1 = sc.nextInt();
        double fee1 = sc.nextDouble();
        sc.nextLine(); // consume leftover newline

        Course c1 = new Course(name1, duration1, fee1);

        // Input second course
        String name2 = sc.nextLine();
        int duration2 = sc.nextInt();
        double fee2 = sc.nextDouble();

        Course c2 = new Course(name2, duration2, fee2);

        // Display course details
        System.out.println("--- Before Institute Update ---");
        c1.displayCourseDetails();
        System.out.println();
        c2.displayCourseDetails();

        // Update institute name
        Course.updateInstituteName("XYZ Learning Center");

        // Display after institute update
        System.out.println("\n--- After Institute Update ---");
        c1.displayCourseDetails();
        System.out.println();
        c2.displayCourseDetails();

        sc.close();
    }
}
