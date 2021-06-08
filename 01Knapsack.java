
// Time Complexity : O(M*N)
// Space Complexity : O(M*N) 
// Did this code successfully run on Leetcode/ GFG : Yes
// Any problem you faced while coding this : None

import java.io.*;

class GFG {
	public static void main (String[] args) {
		System.out.println("GfG!");
		int val[] = new int[] { 60, 100, 120, 90 };
        int wt[] = new int[] { 10, 20, 30, 40 };
        int W = 60;
        
        // using the helper and recursive way that will give TLE for large inputs
        System.out.println(helper(wt, val, W, 0, 0));
        
        
        // using the dp way
        int[][] dp = new int[val.length+1][W+1];
        
        for(int i=1; i<dp.length; i++) {
            for(int j=1; j< dp[0].length; j++) {
                if (wt[i - 1] > j) {
                    //Skip if the  weight at the current index > the remaining weight
                    dp[i][j] = dp[i - 1][j];
                } else {
                    //maximum value by excluding or including the i'th item
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - wt[i - 1]] + val[i - 1]);
                }
            }
        }
        
        System.out.println(dp[dp.length-1][dp[0].length-1]);
	}
	
	private static int helper(int[] weights, int[] profits, int w, int index, int profit) {
	    //Base
	    if(w == 0 || index == weights.length)
	        return profit;
	    
	    if(weights[index] > w) {
	        //If the  weight at the current index > the remaining weight, we skip that index.
	        return helper(weights,profits, w, index+1, profit);
	    } else {
    	    //Case0 -- skip the weight
    	    int case0 = helper(weights,profits, w, index+1, profit);
    	    
    	    //Case1
    	    int case1 = helper(weights,profits, w - weights[index], index+1, profit+profits[index]);
    	    return Math.max(case0, case1);
	    }
	}
}