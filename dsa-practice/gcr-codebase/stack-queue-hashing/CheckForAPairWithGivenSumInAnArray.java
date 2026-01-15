import java.util.*;
public class CheckForAPairWithGivenSumInAnArray {
	public static void main(String[] args) {
		
		int[] arr = {0, -1, 2, -3, 1};
		int target = -100;
		
		System.out.println(
			    isPossible(arr, target) ? "Found pair" : "Not possible"
			);
	}
	
	public static boolean isPossible(int[] arr, int target) {
		
		Set<Integer> set = new HashSet<>();
		
		//Pair found
		for(int i : arr) {
			if(set.contains(target - i)) return true; //return true
			
			set.add(i);
		}
		
		return false; //else false
	}
}
