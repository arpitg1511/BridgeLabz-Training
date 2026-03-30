import java.util.*;
public class TotalNoOfHandshakes {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int noOfStudents = sc.nextInt();
		int handshakes = ((noOfStudents * (noOfStudents - 1)) / 2);
		System.out.println("Total no of handshakes between " + noOfStudents + " no. of students are " +
		handshakes);
		
	}
}
