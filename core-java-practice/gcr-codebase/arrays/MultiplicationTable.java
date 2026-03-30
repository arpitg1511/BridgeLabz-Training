import java.util.*;
public class MultiplicationTable {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] multiples = new int[10];
		
		for(int i = 1; i <= 10; i++) { //Loop from 1 to 10
			multiples[i - 1] = n * i;
			System.out.printf("%d * %d = %d \n", n, i, multiples[i - 1]); //Multiplication from array
		}
		
		sc.close();
	}
}
