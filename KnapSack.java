package Oct26;

/* 
Time Complexity: O(nw) where n is no.of elements in the weights/val array and w is max capacity.
Because we need to iterate through all n elements of weights and profits array which is O(n).
Also, we need to populate the dp matrix m*w elements.

Space Complexity: O(nw)
Also, we need to populate the dp matrix m*w elements.
      
Did this code successfully run on Eclipse and GeeksForGeeks : Yes

Any problem you faced while coding this : No

Approach:
Recursive approach identified first. Then, DP array used to optimize repeating subproblems.
  
*/ 

class KnapSack {

	// Driver program to test the function
	public static void main(String args[]) {
		int val[] = new int[] { 1,2,6 };
		int wt[] = new int[] { 2,3,5 };
		int W = 8;
		int n = val.length;
		
		if (val == null || wt == null || val.length == 0 || wt.length == 0) {
			System.out.println("Inadequate input data.");
		}
		else {
			System.out.println(knapSack(W, wt, val, n));
		}
		
	}

	public static int knapSack(int W, int[] wt, int[] val, int n) {

		// dp array with rows having weights array elements(includes 0 at row 0) and cols having capacity (0 to max capacity given)
		int[][] dp = new int[n + 1][W + 1];

		// first row and first column of the dp array will have 0 as the profit, which is the default value for an array, so no need to initialize
		
		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < W + 1 ; j++) {
				if (wt[i-1] > j) {
					dp[i][j] = dp[i-1][j];
				} else {
					// Option 1) Do not select the weight at i-1. => Pick the value from one row above and same column.
					// Option 2) Select the weight at i-1. => Add the (profit for i-1) to (profit value for dp array element at (i-1)th row and weight = j-weight of i selected).
					// Take max of Options 1 and 2 to be initialized at dp[i][j].
					
					// i-1 taken because dp array has rows one more than the size of wt(and also val) array.
					dp[i][j] = Math.max(dp[i - 1][j], val[i-1] + dp[i - 1][j - wt[i-1]]);
				}
			}
		}

		return dp[n][W];

	}

}
