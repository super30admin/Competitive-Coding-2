/*
  Time complexity: O(n*W)
  Space complexity: O(W)

  Code ran successfully on GFG: Yes

  Approach: Each of the elements is computed as the maximum of the value from the previous row or the sum of the current value and remaining sack capacity value from previous row.

*/

class Solution {
    static int knapsack(int W, int val[], int wt[]) {
        // code here
        int n = val.length;
        int dp[] = new int[W + 1];

        for (int i = 0; i < n; i++) {
            for (int w = W; w >= wt[i]; w--) {
                dp[w] = Math.max(dp[w], val[i] + dp[w - wt[i]]);
            }
        }

        return dp[W];
    }
}

