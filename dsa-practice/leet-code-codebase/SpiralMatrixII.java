
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] arr = new int[n][n];
        int top = 0;
        int bottom = n-1;
        int right = n-1;
        int left = 0;
        int k = 1;
        while(top <= bottom && left <= right){
            for(int i = left; i <= right; i++){
                arr[top][i] = k;
                k++;
            }
            top++;
            
            for(int i = top; i <= bottom; i++){
                arr[i][right] = k;
                k++;
            }
            right--;

            if(!(top <= bottom && left <= right))
            break;

            for(int i = right; i >= left; i--){
                arr[bottom][i] = k;
                k++;
            }
            bottom--;

            for(int i = bottom; i >= top; i--){
                arr[i][left] = k;
                k++;
            }
            left++;
        }

        return arr;
    }
}
