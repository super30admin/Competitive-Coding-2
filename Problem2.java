// 0/1 Knapsack
// Time Complexity : O(n * W) // where n is number of values, W is that capacity
// Space Complexity : O(W)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/* We use dp here as we can see repeated subproblems here. We use space optimized 1-d dp array. We take 2 cases when we dont include then dp[j] stays same as
   previous row else dp[j] = dp[j - w[i - 1]]. Since we need values to left and previous row, we move from right to left to preserve the previous row values.
   In the end the value contained in dp[m] is the max value we can get.
*/

public class Knapsack {

	// Returns the maximum value that
	// can be put in a knapsack of
	// capacity W
	static int knapSack(int[] val, int[] w, int idx, int W, int maxVal)
	{
		if(val == null || val.length == 0)
		    return -1;
		    
		if(w == null || w.length == 0)
		    return -1;
		    
		int n = val.length;
		int m = W;
		
		int[] dp = new int[m + 1];
		
		for(int i = 1; i <= n; ++i) {
		    for(int j = m; j >= 0; --j) {
		        if(j >= w[i - 1])
		            dp[j] = Math.max(dp[j], val[i - 1] + dp[j - w[i - 1]]);
		        }
		}
		return dp[m];
	}

	// Driver code
	public static void main(String args[])
	{
		int val[] = new int[] { 55, 10, 47, 5, 4, 50, 8, 61, 85, 87 };
		int wt[] = new int[] { 95, 4, 60, 32, 23, 72, 80, 62, 65, 46 };
		int W = 269;
		int n = val.length;
		System.out.println(knapSack(val, wt, 0, W, 0)); //295
	}
}


// Time Complexity : O(2 ^ n) // where n is number of values
// Space Complexity : O(n), stack space needed for recursion
/* A Naive recursive implementation
of 0-1 Knapsack problem */
public class Knapsack {

	// Returns the maximum value that
	// can be put in a knapsack of
	// capacity W
	static int knapSack(int[] val, int[] w, int idx, int W, int maxVal)
	{
		//System.out.println(idx);
		//System.out.println(W);
		if(W < 0)
		    return -1;
		//Base case
		if(W == 0 || idx == val.length)
		    return maxVal;
		    
		
		    
		/*if(W < w[idx])
		    return knapSack(val, w, idx + 1, W);*/
		    
		
		    
		int case0 = knapSack(val, w, idx + 1, W, maxVal);
		int case1 = knapSack(val, w, idx + 1, W - w[idx], maxVal + val[idx]);
		
		if(case0 == -1)
		    return case1;
		if(case1 == -1)
		    return case0;
		    
		return Math.max(case0, case1);
	}

	// Driver code
	public static void main(String args[])
	{
		int val[] = new int[] { 55, 10, 47, 5, 4, 50, 8, 61, 85, 87 };
		int wt[] = new int[] { 95, 4, 60, 32, 23, 72, 80, 62, 65, 46 };
		int W = 269;
		int n = val.length;
		System.out.println(knapSack(val, wt, 0, W, 0));
	}
}

