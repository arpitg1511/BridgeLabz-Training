import java.util.*;
public class BinarySearch {
	public static int binarySearch(int[] arr, int target) {
		
		Arrays.sort(arr);
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) return mid;
            else if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }
	
	public static void main(String[] args) {
    	int[] arr = {1, 2, 1, 13, 4};
    	
    	System.out.println(binarySearch(arr, 4));
	}
}
