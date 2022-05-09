// Time Complexity : O(N.M) N = Capacity, M = #values or #weights
// Space Complexity : O(N.M)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
public class Knapsack {

    private static int helper(int[] values,int[] weight, int cap){
        int n = weight.length;
        int dp[][] = new int[n + 1][cap + 1];
        for(int i =0; i<n;i++) {
            dp[i][0] = 0;
        }
        for(int i =0; i<dp[0].length;i++) {
            dp[0][i] = 0;
        }
        for (int i = 1; i <= n; i++)
        {
            for (int w = 1; w <= cap; w++)
            {
                if (i == 0 || w == 0)
                    dp[i][w] = 0;
                else if (weight[i - 1] <= w)
                    dp[i][w]
                            = Math.max(values[i - 1]
                                    + dp[i - 1][w - weight[i - 1]],
                            dp[i - 1][w]);
                else
                    dp[i][w] = dp[i - 1][w];
            }
        }

        return dp[n][cap];
    }
    public static void main(String[] args) {
        int[] values = new int[]{60, 100, 120};
        int[] weights = new int[]{10,20,30};
        int W = 50;

        System.out.println( helper(values, weights, W));
    }
}
