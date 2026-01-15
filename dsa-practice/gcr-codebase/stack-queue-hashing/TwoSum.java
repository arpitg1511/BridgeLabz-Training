import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
public class TwoSum {
	public static void main(String[] args) {
		
		int[] arr = {0, -1, 2, -3, 1};
		int target = -2;
		
		int[] ans = foundArr(arr, target);
		System.out.println(
			     Arrays.toString(ans)
			);
	}
	
	public static int[] foundArr(int[] arr, int target) {
		
		Set<Integer> set = new HashSet<>();
		
		//Pair found
		for(int i : arr) {
			if(set.contains(target - i)) return new int[] {i, target - i}; //return pair
			
			set.add(i);
		}
		
		return new int[]{}; //else empty array
	}
}
