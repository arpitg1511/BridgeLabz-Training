import java.util.*;

public class ZeroSumSubarrays {

    public static void findZeroSumSubarrays(int[] arr) {

        // Map: prefixSum -> list of indices where it occurred
        Map<Integer, List<Integer>> mp = new HashMap<>();

        int sum = 0;

        // Base case: prefix sum 0 at index -1
        mp.put(0, new ArrayList<>());
        mp.get(0).add(-1);

        for (int i = 0; i < arr.length; i++) {

            sum += arr[i];

            if (mp.containsKey(sum)) {
                for (int start : mp.get(sum)) {
                    System.out.println("Subarray: " + (start + 1) + " to " + i);
                }
            }

            mp.putIfAbsent(sum, new ArrayList<>());
            mp.get(sum).add(i);
        }
    }

    public static void main(String[] args) {

        int[] arr = {3, 4, -7, 3, 1, 3, -4, -2, -2};

        findZeroSumSubarrays(arr);
    }
}
