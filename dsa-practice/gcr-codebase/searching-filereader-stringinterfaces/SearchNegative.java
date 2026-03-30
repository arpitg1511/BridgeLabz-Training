import java.util.*;
public class SearchNegative {
	public static void main(String[] args) {
		int[] arr = {23, 15, -481, 74, 582,-27}; //Array Declared
		
		System.out.println(firstNegative(arr)); // Method called
	}
	
	public static int firstNegative(int[] arr) {
		
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] < 0) return i; //Check if negative
		}
		
		return -1; // No negative number found
	}
}