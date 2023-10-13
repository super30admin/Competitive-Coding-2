// Time Complexity : O(N * W)
// Space Complexity : O(W)
// Did this code successfully run on geeksforgeeks : yes
// Any problem you faced while coding this : I didnt face any problem while coding this

class Solution {
    public int knapSack(int W, int wt[], int val[], int n) {
        int[] dp = new int[W + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int w = W; w >= 0; w--) {
                if (wt[i - 1] <= w)
                    dp[w]= Math.max(dp[w], dp[w - wt[i - 1]]+ val[i - 1]);
            }
        }

        return dp[W];
    }
}