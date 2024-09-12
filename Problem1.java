// Time Complexity : 0(mn)
// Space Complexity : 0(mn)
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// Approach: We use the DP matrix approach. The two variables are the capacity(columns) and the weights(rows) of the items
// For weight 0(1st row) all values will be 0 and the first column(capcity 0) for all the weights will be 0
// For remaining weights x capacities, we have 2 options choose and not choose, get the maximum out of both if the result is valid
// otherwise get the previous weight i.e. from the row above

class Problem1 {
    
    public static int knapSack(int[] values, int[] weights, int capacity) {
        //edge cases
        if (weights == null || weights.length == 0)
            return 0;
        if (values == null || values.length == 0)
            return 0;

        int[][] dp = new int[weights.length + 1][capacity + 1];

        //fill the first row with 0
        for (int i = 0; i < capacity; i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i <= weights.length; i++) {
            for (int j = 0; j <= capacity; j++) {
                if (weights[i - 1] <= j) {
                    int value1 = values[i - 1] + dp[i - 1][j - weights[i - 1]];
                    int value2 = dp[i - 1][j];
                    dp[i][j] = Math.max(value1, value2);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[weights.length][capacity];
    }
}