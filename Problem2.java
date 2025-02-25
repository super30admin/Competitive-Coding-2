class Solution {
    // Function to return max value that can be put in knapsack of capacity.
    static int knapSack(int capacity, int val[], int wt[]) {
        // code here
        int[][] dp = new int[wt.length+1][capacity+1];

        for(int i=0; i<=capacity; i++){
            dp[0][i] = 0;
        }

        for(int i=1; i<=wt.length; i++){
            for(int j =1; j<=capacity; j++){
                if(wt[i-1] > j){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], val[i-1] + dp[i-1][j - wt[i-1]]);
                }
            }
        }
        return dp[wt.length][capacity];
    }
}
