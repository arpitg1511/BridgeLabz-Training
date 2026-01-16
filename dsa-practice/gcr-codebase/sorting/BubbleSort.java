import java.util.*;
public class BubbleSort {
	public static void main(String[] args) {
		
		int[] marks = {12, 3, 65, 17, 18, 25};
		
		System.out.println(Arrays.toString(marks));
		
		bubbleSort(marks);
		
		System.out.println(Arrays.toString(marks));
		
	}
	
	public static void bubbleSort(int[] arr) {
		
		for(int i = 0; i < arr.length; i++) {
			
			boolean swap = false;
			
			for (int j = 0; j < arr.length - i - 1; j++) {

	            if (arr[j] > arr[j + 1]) {
	                int temp = arr[j];
	                arr[j] = arr[j + 1];
	                arr[j + 1] = temp;
	                swap = true;
	            }
	        }
			
			if(!swap) return;
		}
		
		return;
	}
}
