class Knapsack {
	//Time Complexity : O(n*m), where n is the length of weights and m in capacity 
	//Space Complexity : O(n*m), where n is for storing weights and m for capacity
	//Did this code successfully run on Leetcode : Yes
	//Any problem you faced while coding this : Time
	public int knapSack(int[] weights, int[] values, int capacity) {
		int[][] dp = new int[weights.length + 1][capacity + 1];
		
		for(int i=1; i<weights.length + 1; i++) {
			for(int j=1; j<capacity + 1; j++) {
				if(j >= weights[i-1])
					dp[i][j] = Math.max(values[i-1] + dp[i-1][j - weights[i-1]], dp[i-1][j]);
				else
					dp[i][j] = dp[i-1][j];
			}
		}
		
		return dp[weights.length][capacity];
	}
	
	//Time Complexity : O(2^n), where n is the length of tree formed by 
	//Space Complexity : O(n) for stack which is equal to n
	//Did this code successfully run on Leetcode : Yes
	//Any problem you faced while coding this : No
	public int knapSack1(int[] weights, int[] values, int capacity) {
		return helper(weights, values, capacity, 0, 0);
	}
	
	private int helper(int[] weights, int[] values, int capacity, int profit, int idx) {
		// base
		if(idx == weights.length && capacity < 0)
			return 0;
		if(capacity == 0 || idx == weights.length)
			return profit;
		
		// logic
		// choose
		int case1 = helper(weights, values, capacity - weights[idx], profit + values[idx], idx + 1);
		
		// don't choose
		int case2 = helper(weights, values, capacity, profit, idx + 1);
		
		return Math.max(case1, case2);
	}
}