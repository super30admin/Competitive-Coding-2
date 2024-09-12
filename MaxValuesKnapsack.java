/*
 * 0-1 Knapsack Problem | DP-10
 * 
 * we are given weights and values of n items. we need to put these items in a knapsack of capacity W to get maximum value in our knapsack.

or we can say that we are given two integers arrays val[0......n-1] and wt[0.....n-1] which represent values and weights associated with n items respectively. we are also given an integer W  which represents knapsack capacity.

find out the maximum value subset of val[] such that sum of the weights of this subset is smaller than or equal to W. but you cannot break an item, either pick the complete item or dont pick it(known as 0-1 property).


Input:

weight[] = {10,20,30};
value[] = {60,100,120};
W = 50

Output:
220

 */

package com.s30.edu.competitivecoding2;

/*
 * Time Complexity: O (NxM) -> traversing through rows and columns in matrix
 * 
 * Space Complexity: O (NxM) -> Created a matrix of N rows and M columns
 * 
 * Did this code successfully run on leetcode: Not on leetcode
 * 
 * Any problem you faced while coding this: Faced problem while coming up with the DP solution
 * 
 */

public class MaxValuesKnapsack {
	
	public int maximumValue(int[] weights, int[] values, int W) {
		
		// Create a 2D matrix with 'weights.length+1' rows and 'W+1' columns
		int[][] dp = new int[weights.length+1][W+1];
		
		/*
         * Fill up the first column with 0
         * The values inserted for weight capacity '0' will be 0
         */
		for(int i = 0; i <= weights.length; i++) {
			dp[i][0] = 0;
		}
		
		/*
         * Fill up the first row starting from second column with 0
         * The values inserted with weight '0' for any weight capacity will be 0
         */
		for(int j = 1; j <= W; j++) {
			dp[0][j] = 0;
		}
		
		
		/*
         * After filling up the first column and row 
         * Traverse through the remaining rows and columns of matrix
         * 
         * Check:
         * 	1. If the weight capacity is less than given weight
         * 	   - If yes, we cannot insert the item corresponding to the weight in knapsack
         * 		 So, copy the value from top of matrix 
         *  2. Else, in other cases, we can insert the item corresponding to current and previous weights
         *     In such cases, we go for choose or don't choose the current weight
         *     DC:
         *     	- If we don't choose, then copy the value from top in matrix
         *     C:
         *     	- If we choose, e.g: from [1,3] for weight capacity = 3
         *     		1- then, take the value corresponding to the current weight
         *     		- then we compute the remaining weight capacity by subtracting the current index weight (weight added) from the weight capacity
         *     		2- And, get the value at index 'j' (remaining weight capacity)
         *  		Add 1 and 2 
         *     Then, we take the maximum of both -> max(C, DC)
         *     
         * We repeat the steps 1 or 2 until all the values in matrix are filled
         * 
         * After exiting the for loops, return the last value in matrix
         * 	
         */
		
		for(int i = 1; i <= weights.length; i++) {
			for(int j = 1; j <= W; j++) {
				if(j < weights[i-1]) {
					dp[i][j] = dp[i-1][j];
				}
				else {
					dp[i][j] = Math.max(dp[i-1][j], values[i-1] + dp[i-1][j - weights[i-1]]);
				}
			}
		}
		
		return dp[weights.length][W];
		
	}
	
	// main method
	public static void main(String[] args) {
		MaxValuesKnapsack max = new MaxValuesKnapsack();
		//int[] weight = {1,3,4,5};
		//int[] values = {1,4,5,7};
		//int w = 7;
		
		//int[] weight = {1,2,3};
		//int[] values = {10,15,40};
		//int w = 6;
		
		//int[] weight = {1,1,1};
		//int[] values = {10,20,30};
		//int w = 2;
		
		int[] weight = {10,20,30};
		int[] values = {60,100,120};
		int w = 50;
		
		int maxValue = max.maximumValue(weight, values, w);
		System.out.println(maxValue);
	}

}
