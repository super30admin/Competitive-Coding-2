// Time Complexity : O(n*w) where n is number of items and w is max weight
// Space Complexity : O(n*w)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
/**
 * Using bottom up dp approach where we calculate max profit for each weight via picking and not-picking the element.
 * The last index on the 2d array will have the max profit for all choices.
 */
public class Knapsack {
    int maxProfit(int[] weights, int[] profits, int maxWeight) {
        int n = weights.length;
        int[][] dp = new int[n+1][maxWeight+1];

        for (int i =1; i <=n;i++) {
            for (int j=1;j <= maxWeight;j++) {
                int pick = 0;

                if (weights[i-1] <= j) {
                    pick = profits[i-1] + dp[i-1][j - weights[i-1]];
                }

                int notPick = dp[i-1][j];

                dp[i][j] = Math.max(pick, notPick);
            }
        }

        return dp[n][maxWeight];
    }

    public static void main(String[] args) {
        System.out.println(new Knapsack().maxProfit(new int[]{4,5,1}, new int[]{1,2,3}, 4));
        System.out.println(new Knapsack().maxProfit(new int[]{4,5,1}, new int[]{1,2,3}, 5));
        System.out.println(new Knapsack().maxProfit(new int[]{4,5,2}, new int[]{1,2,3}, 1));
    }
}