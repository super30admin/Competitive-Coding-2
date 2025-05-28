//start from the last row and move upwards while chosing the max weight
//Time complexity: O(n^2)
//Space complexity: O(n^2)
class Problem2 {
 public static int knapsack(int W, int[] val, int[] wt) {
        int[] dp = new int[W + 1];
        
        for (int i = 1; i <= wt.length; i++) {
            for (int j = W; j >= wt[i - 1]; j--) {
                dp[j] = Math.max(dp[j], dp[j - wt[i - 1]] + val[i - 1]);
            }
        }
        return dp[W];
    }
}