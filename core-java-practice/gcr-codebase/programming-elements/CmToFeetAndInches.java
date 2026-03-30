import java.util.*;
public class CmToFeetAndInches {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double cm = sc.nextDouble();
		double inch = cm / 2.54;
		double feet = inch / 12;
		
		System.out.println("Your height in cm is " + cm + " while in feet is " + 
		feet + " and inches is " + inch);
	}
}
