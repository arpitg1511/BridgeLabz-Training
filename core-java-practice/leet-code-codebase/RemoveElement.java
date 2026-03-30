import java.util.Iterator;

public class RemoveElement {
	public static void main(String[] args) {
		int[] arr = {3, 2, 2, 3}
		int val = 3;
		int j = removeElement(arr, val);
		for (int i = 0; i < j; i++) {
			System.out.println(arr[i]);
		}
	}
	
	public static int removeElement(int[] arr, int val) {
        int i = 0;
        int j = 0;
        while(j < arr.length){
            if(arr[j] != val){
                arr[i] = arr[j];
                i++;
            }
            j++;
        }
        return i;
    }
}
