 // Time Complexity : O(N*W)
// Space Complexity : O(W)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english

// Your code here along with comments explaining your approach
/*
 * Construct a DP and check if the weight without considering the element is greater or the weight considering. 
 * Take the maximum value and compute the DP table. 
 */
class Problem1 {
    public int knapSack(int W, int wt[], int val[], int n)
    {
        // Making and initializing dp array
        int[] dp = new int[W + 1];
 
        for (int i = 1; i < n + 1; i++) {
            for (int w = W; w >= 0; w--) {
 
                if (wt[i - 1] <= w)
 
                    // Finding the maximum value
                dp[w] = Math.max(dp[w], dp[w - wt[i - 1]] + val[i - 1]);
            }
        }
        return dp[W];
    }
}