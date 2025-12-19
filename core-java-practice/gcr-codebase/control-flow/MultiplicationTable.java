import java.util.*;
public class MultiplicationTable {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		
        // Loop from 6 to 9 to generate the multiplication table
		for(int i = 6; i < 10; i++) {
			System.out.println(number + " * " + i + " = " + (number * i));
		}
		
		sc.close();
	}
}
