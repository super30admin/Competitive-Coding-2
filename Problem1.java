// Time Complexity : O(items.length * TotalWeight)
// Space Complexity : O(items.length * TotalWeight)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Approach
// This problem is similar to the coins change 1
// we have the choice of picking an item or not
// We observe that we have overlapping subproblems
// So we can use dp to solve this problem

public class Problem1 {

    public static void main(String[] args) {
        int[] wt = { 2, 2, 1, 3, 4 };
        int[] val = { 12, 10, 5, 20, 35 };
        int W = 6;
        int n = 5;

        System.out.println("Max Profit: " + knapsack(wt, val, W, n));

    }

    public static int knapsack(int[] wt, int[] val, int W, int n) {
        int[][] t = new int[n + 1][W + 1];

        for (int i = 1; i < n + 1; i++)
            for (int j = 1; j < W + 1; j++) {
                if (wt[i - 1] <= j)
                    t[i][j] = Math.max(val[i - 1] + t[i - 1][j - wt[i - 1]], t[i - 1][j]);
                else
                    t[i][j] = t[i - 1][j];
            }
        return t[n][W];
    }
}
