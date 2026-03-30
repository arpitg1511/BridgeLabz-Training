import java.util.*;
public class SelectionSort {
	public static void main(String[] args) {
		int[] marks = {10, 43, 64, 12, 42};
		
		System.out.println(Arrays.toString(marks));
		
		selectionSort(marks);
		
		System.out.println(Arrays.toString(marks));
	}
	
	public static void selectionSort(int[] arr) {
		
		for(int i = 0; i < arr.length; i++) {
			int min = i;
			
			for(int j = i + 1; j < arr.length; j++) {
				if(arr[min] > arr[j]) min = j;
			}
			
			int temp = arr[i];
			arr[i] = arr[min];
			arr[min] = temp;
		}
	}
}
