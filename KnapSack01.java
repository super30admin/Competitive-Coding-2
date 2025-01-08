class KnapSack01 {
    // Function to return max value that can be put in knapsack of capacity.
    static int knapSack(int capacity, int val[], int wt[]) {
        // code here
        if(val.length != wt.length){
            return 0;
        }

        int[][] dp = new int[val.length + 1][capacity + 1];

        for(int i=1;i<val.length+1; i++){
            for(int j=1; j<capacity+1; j++){
                if(j < wt[i-1]){
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = Math.max(val[i-1] + dp[i-1][j-wt[i-1]], dp[i-1][j]);
                }
            }
        }
        return dp[val.length][capacity];
    }
}
