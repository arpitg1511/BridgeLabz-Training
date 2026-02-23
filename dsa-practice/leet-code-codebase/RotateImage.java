class Solution {
    public void rotate(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++) {
            for(int j = i + 1; j < matrix.length; j++) {
                int t = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = t;
            }
        }

        for(int i = 0; i < matrix.length; i++) {
            reverse(matrix[i]);
        }
    }

    public void reverse(int[] arr) {
        int n = arr.length;
        int i = 0;
        int j = n - 1;
        while(i < j) {
            int t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
            i++;
            j--;
        }
    }
}