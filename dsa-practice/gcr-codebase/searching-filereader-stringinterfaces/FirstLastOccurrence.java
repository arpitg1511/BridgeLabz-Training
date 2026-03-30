public class FirstLastOccurrence {

    public static int firstOccurrence(int[] arr, int target) { // For first occurrence
        int left = 0, right = arr.length - 1, ans = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                ans = mid;
                right = mid - 1; // Found but have to find first
            } else if (arr[mid] < target) {
                left = mid + 1; // Will be in latter half
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    public static int lastOccurrence(int[] arr, int target) { // For last occurrence
        int left = 0, right = arr.length - 1, ans = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                ans = mid;
                left = mid + 1; // found but have to find last
            } else if (arr[mid] < target) {
                left = mid + 1; // Will be in latter half
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 2, 3, 4};
        System.out.println(firstOccurrence(arr, 2));
        System.out.println(lastOccurrence(arr, 2));
    }
}
