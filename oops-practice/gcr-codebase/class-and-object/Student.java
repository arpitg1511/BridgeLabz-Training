import java.util.*;
public class Student {
	String name;
	String rollNumber;
	double[] marks;
	
	public Student(String name, String rollNumber, double[] marks) {
		this.name = name;
		this.rollNumber = rollNumber;
		this.marks = marks;
	}
	
	void display() {
		System.out.println("Student Name: " + name);
		System.out.println("Student RollNumber: " + rollNumber);
		System.out.println("Student Marks: ");
		for(int i = 0; i < marks.length; i++) {
			System.out.printf("Marks%d: %.1f\n", i + 1, marks[i]);
		}
	}
	
	String calculateGrade() {
		double total = 0;
		for(int i = 0; i < marks.length; i++) {
			total += marks[i];
		}
		
		double avg = total / marks.length;
		
		if(avg >= 90) return "O";
		if(avg >= 80) return "A+";
		if(avg >= 70) return "A";
		if(avg >= 60) return "B+";
		if(avg >= 50) return "B";
		if(avg >= 30) return "C";
		return "F";
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String name = sc.nextLine();
		String rollNumber = sc.next();
		double[] marks = new double[3];
		
		for(int i = 0; i < 3; i++) {
			marks[i] = sc.nextDouble();
		}
		
		Student st = new Student(name, rollNumber, marks);
		
		st.display();
		System.out.println("Grade " + st.calculateGrade());
		
		sc.close();
	}
}
