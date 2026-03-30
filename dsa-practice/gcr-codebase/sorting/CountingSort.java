import java.util.*;

public class CountingSort {

    public static void main(String[] args) {

        int[] ages = {12, 15, 10, 18, 14, 12, 16, 15, 10};

        System.out.println("Before Sorting:");
        System.out.println(Arrays.toString(ages));

        countingSort(ages);

        System.out.println("After Sorting:");
        System.out.println(Arrays.toString(ages));
    }

    public static void countingSort(int[] arr) {

        int minAge = 10;
        int maxAge = 18;

        int range = maxAge - minAge + 1;
        int[] count = new int[range];

        // Step 1: Count frequency
        for (int age : arr) {
            count[age - minAge]++;
        }

        // Step 2: Cumulative frequency
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        // Step 3: Build output array (stable)
        int[] output = new int[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) {
            int age = arr[i];
            int index = count[age - minAge] - 1;
            output[index] = age;
            count[age - minAge]--;
        }

        // Step 4: Copy back
        for (int i = 0; i < arr.length; i++) {
            arr[i] = output[i];
        }
    }
}
