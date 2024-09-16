// robot traversal in a matrix for given m-rows and n-columns. destination is always arr[m-1][n-1]. Starting point is always arr[0][0]
// m*n is the time complexity
// space complexity is m*n

class Solution {
    public int uniquePaths(int m, int n) {
        int[][] matrix = new int[m][n];

        // invalied case
        if (m == 0 || n == 0) {
            return 0;
        }

        // inserting single ways
        for (int i = 0; i < matrix[0].length; i++) {
            matrix[m - 1][i] = 1;
        }
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][n - 1] = 1;
        }

        for (int i = matrix.length - 2; i >= 0; i--) {
            for (int j = matrix[0].length - 2; j >= 0; j--) {
                matrix[i][j] = matrix[i][j + 1] + matrix[i + 1][j];
            }
        }

        return matrix[0][0];
    }
}