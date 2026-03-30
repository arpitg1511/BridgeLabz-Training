import java.util.*;
public class MergeSort {
	public static void main(String[] args) {
		
		int[] marks = {12, 3, 65, 17, 18, 25};
			
		System.out.println(Arrays.toString(marks));
		
		mergeSort(marks, 0, marks.length - 1);
			
		System.out.println(Arrays.toString(marks));
			
	}
	
	public static void mergeSort(int[] arr, int l, int r) {
		if(l >= r) return;
		
		int mid = (l + r) / 2;
		
		mergeSort(arr, l, mid);
		mergeSort(arr, mid + 1, r);
		
		merge(arr, l, mid, r);
	}
	
	static void merge(int[] arr, int l, int mid, int r) {

	    int n1 = mid - l + 1;
	    int n2 = r - mid;

	    int[] left = new int[n1];
	    int[] right = new int[n2];

	    // copy data
	    for (int i = 0; i < n1; i++) {
	        left[i] = arr[l + i];
	    }

	    for (int j = 0; j < n2; j++) {
	        right[j] = arr[mid + 1 + j];
	    }

	    int i = 0, j = 0, k = l;

	    // merge back
	    while (i < n1 && j < n2) {
	        if (left[i] <= right[j]) {
	            arr[k++] = left[i++];
	        } else {
	            arr[k++] = right[j++];
	        }
	    }

	    // remaining elements
	    while (i < n1) {
	        arr[k++] = left[i++];
	    }

	    while (j < n2) {
	        arr[k++] = right[j++];
	    }
	}
}
