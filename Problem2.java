class Solution {
    static int knapsack(int W, int val[], int wt[]) {
        // code here
        if(val == null || wt == null || W == 0){
            return 0;
        }
        //we use dp[][] of weights till W and calculate the all possible profits for all weights and return for W
        int dp[][] = new int[wt.length+1][W+1];
        //for 0 weight, we dont need any weights, so profit will be 0 so dp[0][i] and we dont pick any weights dp[i][0] is 0
        for(int i=1; i< dp.length; i++){
            for(int j=1; j<dp[0].length; j++){
                //if calculating wt < current wt, we dont pick that weight, so fill it with before wt profit (dp[i-1][j])
                if(j < wt[i-1]){
                    dp[i][j] = dp[i-1][j];
                }
                //if we pick that weight, we take the max profit between (that wt's profit + total wt-current wt int above row) and profit by not picking
                else{
                    dp[i][j] = Math.max((val[i-1]+ dp[i-1][j-(wt[i-1])]), dp[i-1][j]);
                }
            }
        }
        //returning dp[last wt][W]
        return dp[dp.length-1][dp[0].length-1];
    }
}
