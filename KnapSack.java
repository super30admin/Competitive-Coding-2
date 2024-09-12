// Time Complexity : O(n * W) -> W - given integer, n - no of items
// Space Complexity : O(W)
// Did this code successfully run on Leetcode : 
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class KnapSack {
    public int knapSack(int W, int[] wt, int[] val, int n) {
        int[] dp = new int[W+1];

        for(int i=1; i<n+1; i++){
            for(int j=W-1; j>=0; j--){
                if(wt[i-1] <= W){
                    dp[W] = Math.max(dp[W], dp[W - wt[i-1]] + val[i-1]);
                }
            }
        }
        return dp[W];
    }
}