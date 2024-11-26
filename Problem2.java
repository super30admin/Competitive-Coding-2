class Problem2 {

    // Time Complexity: O(nw) (where n -> no. of weights, w -> capacity of knapsack)
    // Space Complexity: O(nw)

    public int knapsack01(int[] weights, int[] values, int capacity){
        if(weights == null || weights.length == 0 || values == null || values.length == 0)
            return 0;

        int[][] dp = new int[weights.length+1][capacity+1];

        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[i].length; j++){
                if(i == 0 || j == 0)
                    dp[i][j] = 0;
                else if(weights[i - 1] > j)
                    dp[i][j] = dp[i - 1][j];
                else{
                    int include = values[i - 1] + dp[i - 1][j - weights[i - 1]];
                    int exclude = dp[i - 1][j];
                    dp[i][j] = Math.max(include, exclude);
                }
            }
        }
        return dp[weights.length][capacity];
    }
}