class Solution {
    public boolean canJump(int[] arr) {
        int acc = 0;
        for(int i = 0; i < arr.length; i++){
            if(acc >= arr.length) return true;

            if(acc < i) return false;

            acc = Math.max(i + arr[i], acc);
        }

        return true;
    }
}