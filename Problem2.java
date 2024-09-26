// Problem - https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/

// Time Complexity : O(n * w)
// Space Complexity : O(2 * w)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Nothing as such

public class problem2 {
    static int knapSack(int W, int wt[], int val[], int n) {
        int i, w;
        int[][] K = new int[2][W + 1];

        for (i = 0; i <= n; i++) {
            for (w = 0; w <= W; w++) {
                if (i == 0 || w == 0)
                    K[i % 2][w] = 0;
                else if (wt[i - 1] <= w)
                    K[i % 2][w] = Math.max(
                            val[i - 1]
                                    + K[(i - 1) % 2][w - wt[i - 1]],
                            K[(i - 1) % 2][w]);
                else
                    K[i % 2][w] = K[(i - 1) % 2][w];
            }
        }
        return K[n % 2][W];
    }

}
