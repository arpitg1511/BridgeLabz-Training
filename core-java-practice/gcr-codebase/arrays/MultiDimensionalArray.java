import java.util.*;

public class MultiDimensionalArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int row = sc.nextInt();
        int col = sc.nextInt();

        // Creating 2D array
        int[][] arr = new int[row][col];

        // Taking input for 2D array
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        // Creating 1D array
        int[] array = new int[row * col];
        int k = 0;

        // Converting 2D array to 1D array
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                array[k] = arr[i][j];
                System.out.println(array[k]); // print current element
                k++;
            }
        }

        sc.close();
    }
}
