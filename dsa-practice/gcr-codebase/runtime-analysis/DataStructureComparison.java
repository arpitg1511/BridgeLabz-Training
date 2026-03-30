import java.util.*;

public class DataStructureComparison {

    public static void main(String[] args) {
        int[] sizes = {1000, 100_000, 1_000_000};

        for (int n : sizes) {
            System.out.println("Dataset Size: " + n);

            // Generate data
            int[] arr = new int[n];
            Random rand = new Random();
            for (int i = 0; i < n; i++) arr[i] = i;

            int target = rand.nextInt(n); // random element to search

            // Array Search
            long start = System.nanoTime();
            arraySearch(arr, target);
            long end = System.nanoTime();
            System.out.println("Array Search: " + (end - start) / 1_000_000.0 + " ms");

            // HashSet Search
            HashSet<Integer> hashSet = new HashSet<>();
            for (int x : arr) hashSet.add(x);
            start = System.nanoTime();
            hashSet.contains(target);
            end = System.nanoTime();
            System.out.println("HashSet Search: " + (end - start) / 1_000_000.0 + " ms");

            // TreeSet Search
            TreeSet<Integer> treeSet = new TreeSet<>();
            for (int x : arr) treeSet.add(x);
            start = System.nanoTime();
            treeSet.contains(target);
            end = System.nanoTime();
            System.out.println("TreeSet Search: " + (end - start) / 1_000_000.0 + " ms");

            System.out.println("----------------------------------");
        }
    }

    // Linear search in array
    public static boolean arraySearch(int[] arr, int target) {
        for (int x : arr) {
            if (x == target) return true;
        }
        return false;
    }
}
