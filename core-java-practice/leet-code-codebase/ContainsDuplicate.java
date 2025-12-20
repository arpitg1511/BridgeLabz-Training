class Solution {
    public boolean containsDuplicate(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        int k = 0;
        for(int i = 1; i < n; i++){
            if(arr[i] == arr[i-1])
            return true;
        }
        return false;
    }
}