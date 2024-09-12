import java.util.*;
//https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/

class Problem1 {
    // Time complexity : O(2**N) [exponential]
    // Space Complexity : O(1)
    static int knapSack(int W, int wt[], int val[]) {
        return helper(W, wt, val, 0, 0);
    }

    static int helper(int W, int wt[], int val[], int index, int profit) {
        if (index >= wt.length || W <= 0)
            return profit;

        if (wt[index] > W)
            return helper(W, wt, val, index + 1, profit);

        int take = helper(W - wt[index], wt, val, index + 1, profit + val[index]);
        int skip = helper(W, wt, val, index + 1, profit);
        return Math.max(take, skip);
    }

    // Time complexity : O(threshold * number of weights)
    // Space Complexity : O(threshold * number of weights)
    static int KnapSackDP(int W, int wt[], int val[]) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < wt.length; i++) {
            map.put(wt[i], val[i]);
        }
        int index = 0;
        for (int weight : map.keySet()) {
            wt[index] = weight;
            val[index++] = map.get(weight);
        }

        int dp[][] = new int[wt.length + 1][W + 1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                int weight = wt[i - 1];
                int points = val[i - 1];
                if (j < weight) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    int take = points + dp[i - 1][W - weight];
                    int skip = dp[i - 1][j];
                    dp[i][j] = Math.max(take, skip);
                }
            }
        }
        return dp[wt.length][W];
    }

    public static void main(String[] args) {
        System.out.println(knapSack(4, new int[] { 1, 2, 3 }, new int[] { 4, 5, 1 }));
        System.out.println(KnapSackDP(4, new int[] { 1, 2, 3 }, new int[] { 4, 5, 1 }));
    }

}
