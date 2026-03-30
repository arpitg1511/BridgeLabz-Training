import java.util.*;

public class TargetSearchLinearVsBinary {

    public static void main(String[] args) {
        test(1_000);
        test(10_000);
        test(1_000_000);
    }

    public static void test(int n) {
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = i; // already sorted
        }

        int target = (int)(Math.random() * n); // FIXED

        long linearStart = System.nanoTime();
        linear(arr, target);
        long linearEnd = System.nanoTime();

        System.out.println("Time taken for " + n +
                " data by Linear Search: " +
                (linearEnd - linearStart) + " ns");

        long binaryStart = System.nanoTime();
        binary(arr, target);
        long binaryEnd = System.nanoTime();

        System.out.println("Time taken for " + n +
                " data by Binary Search: " +
                (binaryEnd - binaryStart) + " ns");

        System.out.println("--------------------------------");
    }

    public static int linear(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target)
                return i;
        }
        return -1; // FIXED
    }

    public static int binary(int[] arr, int target) {
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target)
                return mid;
            else if (arr[mid] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1; // FIXED
    }
}
