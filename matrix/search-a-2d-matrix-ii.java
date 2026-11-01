class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        // Start from top-right corner
        int row = 0;
        int col = cols - 1;

        while (row < rows && col >= 0) {

            int current = matrix[row][col];

            if (current == target) {
                return true;
            }

            // Current value is too large
            // Move left
            else if (current > target) {
                col--;
            }

            // Current value is too small
            // Move down
            else {
                row++;
            }
        }

        return false;
    }
}