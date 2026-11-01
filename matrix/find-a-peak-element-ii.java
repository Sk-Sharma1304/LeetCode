class Solution {
    public int[] findPeakGrid(int[][] mat) {

        int rows = mat.length;
        int cols = mat[0].length;

        int left = 0;
        int right = cols - 1;

        while (left <= right) {

            int midCol = left + (right - left) / 2;
            int maxRow = 0;

            for (int row = 1; row < rows; row++) {
                if (mat[row][midCol] > mat[maxRow][midCol]) {
                    maxRow = row;
                }
            }

            int current = mat[maxRow][midCol];
            int leftValue = (midCol > 0) ? mat[maxRow][midCol - 1]: -1;

            int rightValue = (midCol < cols - 1) ? mat[maxRow][midCol + 1] : -1;
            if (current > leftValue && current > rightValue) {
                return new int[]{maxRow, midCol};
            }
            if (rightValue > current) {
                left = midCol + 1;
            }
            else {
                right = midCol - 1;
            }
        }

        return new int[]{-1, -1};
    }
}