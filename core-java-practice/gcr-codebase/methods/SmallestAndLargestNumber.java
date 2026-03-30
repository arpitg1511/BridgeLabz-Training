import java.util.*;
public class SmallestAndLargestNumber {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int first = sc.nextInt();
		int second = sc.nextInt();
		int third = sc.nextInt();
		
		int[] arr = findSmallestAndLargest(first, second, third);
		System.out.println(arr[0] + " " + arr[1]);
		sc.close();
	}
	
	public static int[] findSmallestAndLargest(int number1, int number2, int number3) {
		int largest = Math.max(number2, Math.max(number1, number3)); // Find largest number
		int smallest = Math.min(number1, Math.min(number2, number3));// Find smallest number
		
		return new int[] {largest, smallest};
	}
}
