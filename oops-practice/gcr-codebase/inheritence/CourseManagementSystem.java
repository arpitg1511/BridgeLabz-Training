import java.util.*;

// Base class representing a generic Course
class Course {
    String courseName;
    int duration; // duration in hours

    // Constructor to initialize course details
    public Course(String courseName, int duration) {
        this.courseName = courseName;
        this.duration = duration;
    }

    // Returns basic course information
    String getCourseDetails() {
        return "Course Name : " + courseName + "\nDuration : " + duration + " hours";
    }
}

// OnlineCourse class extends Course
class OnlineCourse extends Course {
    String platform;
    boolean isRecorded;

    // Constructor initializes course and online-specific details
    public OnlineCourse(String courseName, int duration,
                        String platform, boolean isRecorded) {
        super(courseName, duration); // initialize Course data
        this.platform = platform;
        this.isRecorded = isRecorded;
    }

    // Returns updated course details for online courses
    @Override
    String getCourseDetails() {
        return super.getCourseDetails()
                + "\nPlatform : " + platform
                + "\nRecorded : " + (isRecorded ? "Yes" : "No");
    }
}

// PaidOnlineCourse class extends OnlineCourse
class PaidOnlineCourse extends OnlineCourse {
    double fee;
    double discount; // discount in percentage

    // Constructor initializes course, online, and payment details
    public PaidOnlineCourse(String courseName, int duration,
                            String platform, boolean isRecorded,
                            double fee, double discount) {
        super(courseName, duration, platform, isRecorded); // initialize OnlineCourse data
        this.fee = fee;
        this.discount = discount;
    }

    // Calculates final payable amount after discount
    double calculateFinalFee() {
        return fee - (fee * discount / 100);
    }

    // Returns complete course details including payment info
    @Override
    String getCourseDetails() {
        return super.getCourseDetails()
                + "\nCourse Fee : ₹" + fee
                + "\nDiscount : " + discount + "%"
                + "\nFinal Payable Amount : ₹" + calculateFinalFee();
    }
}

public class CourseManagementSystem {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking input for course details
        System.out.print("Enter Course Name: ");
        String courseName = sc.nextLine();

        System.out.print("Enter Duration (in hours): ");
        int duration = sc.nextInt();
        sc.nextLine(); // clear buffer

        // Taking input for online course details
        System.out.print("Enter Platform: ");
        String platform = sc.nextLine();

        System.out.print("Is the course recorded? (true/false): ");
        boolean isRecorded = sc.nextBoolean();

        // Taking input for paid course details
        System.out.print("Enter Course Fee: ");
        double fee = sc.nextDouble();

        System.out.print("Enter Discount Percentage: ");
        double discount = sc.nextDouble();

        // Parent reference pointing to most derived child object
        Course course = new PaidOnlineCourse(
                courseName, duration, platform, isRecorded, fee, discount
        );

        // Method call resolved at runtime
        System.out.println("\n--- Course Details ---");
        System.out.println(course.getCourseDetails());

        sc.close();
    }
}
