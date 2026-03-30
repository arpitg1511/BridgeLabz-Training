class Solution {
    public int heightChecker(int[] height) {
        int[] arr = new int[height.length];
        for(int i = 0; i < height.length; i++) arr[i] = height[i];
        Arrays.sort(height);

        int c = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] != height[i]) c++;
        }

        return c;
    }
}