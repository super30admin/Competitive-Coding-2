 // TimeComplexity: O(n x W) 
 // SpaceComplexity: O(W)
  
  static int knapsack(int W, int[] val, int[] wt) {
        
        // Initializing dp array
        int[] dp = new int[W + 1];
        
        // Taking first i elements
        for (int i = 1; i <= wt.length; i++) {
            
            // Starting from back, so that we also have data of
            // previous computation of i-1 items
            for (int j = W; j >= wt[i - 1]; j--) {
                dp[j] = Math.max(dp[j], dp[j - wt[i - 1]] + val[i - 1]);
            }
        }
        return dp[W];
    }
