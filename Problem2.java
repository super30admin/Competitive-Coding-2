// Time Complexity: O(n * m) where n = size of weights array + 1, m = total weights + 1
// Space Complexity: O(n * m) extra space for 2D array, where n = size of weights array + 1, m = total weights + 1

// Approach
// Algorithm
// 1 - base condition check
// 2 - initiliaze 2D array
// 3 - initiliaze 1st row and col
// 4 - loop over 2d array to get choose or dont choose values acc to conditions
// 5 - return last element of 2D array
import java.util.*;

public class Main {
	public static int knapSack(int W, int[] wt, int[] val, int n) {
	    // 1
	    if (wt == null || wt.length == 0 || val == null || val.length == 0 || wt.length != val.length) {
	        return 0;
	    }
	    // 2
	    int[][] dp = new int[wt.length + 1][W + 1];
        // 3
	    for(int i=0; i<=wt.length; i++) {
	        dp[i][0] = 0;
	    }
	    for (int j=1; j<=W; j++) {
	        dp[0][j] = 0;
	    }
	    
        // 4
	    for (int i=1; i<=wt.length; i++) {
	        for (int j=1; j<=W; j++) {
	            if (j < wt[i - 1]) {
	                dp[i][j] = dp[i-1][j];
	            } else {
	                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - wt[i - 1]] + val[i - 1]);
	            }
	        }
	    }
	    
        // 5
	    return dp[wt.length][W];
		
	}

	public static void main(String[] args) {
		int val[] = new int[] { 2, 1, 10 };
		int wt[] = new int[] { 10, 20, 30 };
		int W = 50;
		int n = val.length;
		int max_value = knapSack(W, wt, val, n);
		System.out.println("Weights: " + Arrays.toString(wt));
		System.out.println("Value: " + Arrays.toString(val));
		System.out.println("Weight Capacity: " + W);
		System.out.println("Maximum Value: " + max_value);
	}
}