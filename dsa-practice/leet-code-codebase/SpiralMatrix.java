import java.util.*;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ll = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;

        int top = 0;
        int bottom = m - 1;
        int left = 0;
        int right = n - 1;

        while(top <= bottom && left <= right) {

            int i = left;
            while(i <= right) {
                ll.add(matrix[top][i++]);
            }top++;

            i = top;
            while(i <= bottom) {
                ll.add(matrix[i++][right]);
            }
            right--;

            if(!(top <= bottom && left <= right)) break;

            i = right;
            while(i >= left) {
                ll.add(matrix[bottom][i--]);
            }
            bottom--;

            i = bottom;
            while(i >= top) {
                ll.add(matrix[i--][left]);
            }
            left++;
        }

        return ll;
    }
}