public class SearchMatrix {

    public static boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int left = 0;
        int right = rows * cols - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int r = mid / cols; // Mid row
            int c = mid % cols; // Mid column

            if (matrix[r][c] == target) return true; // Target found
            else if (matrix[r][c] < target) left = mid + 1; // In latter half
            else right = mid - 1; // In early half
        }
        return false; // Not found
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 3, 5},
            {7, 9, 11},
            {13, 15, 17}
        };
        System.out.println(searchMatrix(matrix, 9));
    }
}
