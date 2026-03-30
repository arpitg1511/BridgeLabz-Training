import java.util.*;
public class FindRotationPoint {
	public static void main(String[] args) {
		int[] arr = {2, 3, 4, 5, 1};
		
		System.out.println(findPoint(arr));
	}
	
	public static int findPoint(int[] arr) {
		
		int low = 0;
		int high = arr.length - 1;
		
		while(low < high) {
			int mid = low + ((high - low) / 2);
			
			if(arr[mid] > arr[high]) low = mid + 1;
			
			else if(arr[mid] < arr[high]) high = mid;
			
			else high--;
		}
		
		return low;
	}
}
