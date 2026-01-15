import java.util.*;

public class SlidingWindowMaximum {

    public static int[] maxSlidingWindow(int[] arr, int k) {

        if (arr.length == 0 || k == 0) return new int[]{};

        Deque<Integer> dq = new ArrayDeque<>();
        int[] result = new int[arr.length - k + 1];
        int idx = 0;

        for (int i = 0; i < arr.length; i++) {

            // remove elements outside the window
            if (!dq.isEmpty() && dq.peekFirst() == i - k) {
                dq.pollFirst();
            }

            // remove smaller elements from back
            while (!dq.isEmpty() && arr[dq.peekLast()] < arr[i]) {
                dq.pollLast();
            }

            // add current index
            dq.offerLast(i);

            // store result once first window is completed
            if (i >= k - 1) {
                result[idx++] = arr[dq.peekFirst()];
            }
        }

        return result;
    }

    public static void main(String[] args) {

        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

        System.out.println(Arrays.toString(maxSlidingWindow(arr, k)));
    }
}
