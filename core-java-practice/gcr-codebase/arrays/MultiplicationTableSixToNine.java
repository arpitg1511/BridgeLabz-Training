import java.util.Scanner;
public class MultiplicationTableSixToNine {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] multiple = new int[4];
		for(int i = 6; i < 10; i++) { //Loop from 1 to 10
			multiple[i - 6] = n * i; // Multiples stored in array
			System.out.printf("%d * %d = %d \n", n, i, multiple[i - 6]); //Multiplication accesed by array
		}
		
		sc.close();
	}
}
