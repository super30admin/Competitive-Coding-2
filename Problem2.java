//0-1 Knapsack Problem
//Time-complexity : O(n * W) where n is the size of wt[] and W is the weight capacity
//Space-complexity : O(n * W) as our dp[] size will be n * w

class Solution
{
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n)
    {
        // your code here
        //base case
        if(wt.length == 0 || val.length == 0 || wt == null || val == null) return 0;

        int dp[][] = new int[wt.length+1][W+1];

        for(int i = 1; i < wt.length+1; i++){
            for(int j = 1; j < W+1; j++){
                if(j < wt[i - 1]){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-wt[i-1]] + val[i-1]);
                }
            }
        }

        return dp[wt.length][W];
    }
}