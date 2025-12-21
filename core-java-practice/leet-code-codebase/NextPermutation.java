class Solution {
    public void nextPermutation(int[] arr) {
        int n = arr.length;

        int idx = -1;
        for(int i = n - 2; i >= 0; i--) {
            if(arr[i] < arr[i + 1]) {
                idx = i;
                break;
            }
        }

        if(idx == -1) {
            reverse(arr, 0, n - 1);
            return;
        }

        for(int i = n - 1; i > idx; i--) {
            if(arr[i] > arr[idx]) {
                int t = arr[i];
                arr[i] = arr[idx];
                arr[idx] = t;
                reverse(arr, idx + 1, n - 1);
                return;
            }
        }
    }

    public void reverse(int[] arr, int i, int j) {
        while(i < j) {
            int t = arr[i];
            arr[i++] = arr[j];
            arr[j--] = t;
        }
    }
}