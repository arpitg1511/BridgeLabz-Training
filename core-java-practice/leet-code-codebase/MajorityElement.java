class Solution {
    public int majorityElement(int[] arr) {
        int n = arr.length;
        int ans = arr[0];

        int c = 1;
        for(int i = 1; i < n; i++) {
            if(ans != arr[i]) {
                c--;
            }

            if(c == 0) {
                ans = arr[i];
            }

            if(ans == arr[i]) c++;
        }

        return ans;
    }
}