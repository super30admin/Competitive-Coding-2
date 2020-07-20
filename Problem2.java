/**
Problem: 0-1 Knapsack problem

Time Complexity : O(n*C), where n is the number of items, C is the total capacity given.
Space Complexity : O(n*C), where n is the number of items, C is the total capacity given.

Approach: Dynamic programming(similar to coin change problem)
1. Create a matrix where the rows are the items that are available to us, and columns are the weights from 0 to capacity.
2. At every cell in the matrix, there are only two possible choices: We either choose that item, or we don't.    
3. Among these two choices, we always choose the maximum of the two. That is, we check if the total profit obtained from choosing that item is more or the profit obtained from not choosing the item is more.
4. In the end, we are left with the maximum profit at the last element of our DP matrix.
 */

class Knapsack {
    public static void main(String args[]) {
        int capacity = 50;
        int[] weights = new int[]{10,20,30};
        int[] profits = new int[]{60,100,120};
        int n = 3;
        System.out.println(knapSack(weights, profits, capacity, n));
    }
    public static int knapSack(int[] weights, int[] profits, int capacity, int n) {
        int[][] dp = new int[n+1][capacity + 1];
        for(int i = 0; i <= capacity; i++) {
            dp[0][i] = 0; //initialize the first row to zero.
        }
        for(int i = 0; i <= n; i++) {
            dp[i][0] = 0; // intialize the first column to zero.
        }
        for(int i = 1; i<=n; i++) {
            for(int j = 1; j<=capacity; j++) {
                if(j < weights[i-1]) {
                    dp[i][j] = dp[i-1][j];
                }
                else {
                    dp[i][j] = Math.max(dp[i-1][j], profits[i-1] + dp[i-1][j-weights[i-1]]);
                }
            }
        }
        return dp[n][capacity];
    }
}