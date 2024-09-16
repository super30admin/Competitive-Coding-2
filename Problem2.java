import java.util.*;
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int i, k = 0, l = 0;
        List<Integer> ans = new ArrayList<>();
        int m = matrix.length, n = matrix[0].length;
        /*  k - starting row index
        m - ending row index
        l - starting column index
        n - ending column index
        i - iterator
        */
 
        while (k < m && l < n) {
            // Print the first row from the remaining rows
            for (i = l; i < n; ++i) {
                ans.add(matrix[k][i] );
            }
            k++;
 
            // Print the last column from the remaining
            // columns
            for (i = k; i < m; ++i) {
                ans.add(matrix[i][n - 1] );
            }
            n--;
 
            // Print the last row from the remaining rows */
            if (k < m) {
                for (i = n - 1; i >= l; --i) {
                    ans.add(matrix[m - 1][i]);
                }
                m--;
            }
 
            // Print the first column from the remaining
            // columns */
            if (l < n) {
                for (i = m - 1; i >= k; --i) {
                    ans.add(matrix[i][l]);
                }
                l++;
            }
        }
        return ans;
    }
}