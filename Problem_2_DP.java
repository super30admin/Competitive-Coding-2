// Time complexity - O(n^2)
// Space complexity - O(mn)

// Implemented using DP


public class KnapsackDP {

	static int knapSack(int W, int wt[], int val[], int n) {
		int[][] dp = new int[wt.length + 1][W + 1];
		for (int i = 0; i <= n; i++) {
			for (int w = 0; w <= W; w++) {
      // Set  0 for 1st row and 1st column
				if (i == 0 || w == 0)
					dp[i][w] = 0;
         // If current weight is less than capacity then check max value of incuding and excluding that weight
				else if (wt[i - 1] <= w)
					dp[i][w] = Math.max(val[i - 1] + dp[i - 1][w - wt[i - 1]], dp[i - 1][w]);
          // If current weight is greater than capacity, copy the value from upper row.
				else
					dp[i][w] = dp[i - 1][w];
			}
		}
	  // return max value
		return dp[n][W];
	}

	public static void main(String args[]) {
		int wt[] = new int[] { 1,3,5};
		int val[] = new int[] { 600, 100, 120 };
		int W = 4;
		int n = val.length;
		System.out.println(knapSack(W, wt, val, n));
	}

}
