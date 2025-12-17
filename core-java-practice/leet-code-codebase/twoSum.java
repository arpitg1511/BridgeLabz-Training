import java.util.*;
class twoSum {
    public static int[] twoSum(int[] arr, int sum) {
        int n = arr.length;

        Map<Integer, Integer> mp = new HashMap<>();
        for(int i = 0; i < n; i++) {
            if(mp.containsKey(sum - arr[i])) return new int[] { i, mp.get(sum - arr[i]) };

            mp.put(arr[i], i);
        }

        return new int[]{};
    }
}