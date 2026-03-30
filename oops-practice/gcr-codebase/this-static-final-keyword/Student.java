import java.util.*;

public class Student {

	// Shared among all students
	static String universityName = "Global University";
	static int totalStudents = 0;

	final int rollNumber;
	String name;
	String grade;

	// Constructor using this
	public Student(String name, int rollNumber, String grade) {
		this.name = name;
		this.rollNumber = rollNumber;
		this.grade = grade;
		totalStudents++;
	}

	// Displays total students
	static void displayTotalStudents() {
		System.out.println("Total Students Enrolled: " + totalStudents);
	}

	// Displays student details after type check
	void displayDetails(Object obj) {
		if (!(obj instanceof Student)) {
			System.out.println("Invalid Student object");
			return;
		}

		System.out.println("Roll Number: " + rollNumber);
		System.out.println("Name: " + name);
		System.out.println("Grade: " + grade);
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// Student input
		String name = sc.nextLine();
		int roll = sc.nextInt();
		sc.nextLine(); // consume newline
		String grade = sc.nextLine();


		Student s = new Student(name, roll, grade);

		Student.displayTotalStudents();
		System.out.println("University Name: " + Student.universityName);

		s.displayDetails(s);

		sc.close();
	}
}
