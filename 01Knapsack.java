   // Time Complexity : O(m*c) where m is no of weigths/Values 
	 // Space Complexity : O(m*c) and c is capacity
	 // Did this code successfully run on Leetcode : YES
	 // Any problem you faced while coding this : NO


	 // Your code here along with comments explaining your approach
	 public int Knapsack(int[] values, int[] weights, int capacity) {
	     // base checks
	     if (capacity <= 0 || values.length == 0 || weights.length != values.length)
	       return 0;

	     int n = values.length;
	     int[][] dp = new int[n][capacity + 1];

	     // populate the capacity=0 columns
	     for(int i=0; i < n; i++)
	       dp[i][0] = 0;

	     for(int i=1; i < n; i++) {
	     
	       for(int c=1; c <= capacity; c++) {
	       
	         int include= 0, exclude = 0;
	         
	         // include the item, if it is not more than the capacity
	         if(weights[i] <= c)
	           include = values[i] + dp[i-1][c-weights[i]];
	           
	         // exclude the item
	         exclude = dp[i-1][c];
	         
	         // take maximum
	         dp[i][c] = Math.max(include, exclude);
	       }
	     }
	     
	     // maximum profit will be at the bottom-right corner.
	     return dp[n-1][capacity];
	  }
