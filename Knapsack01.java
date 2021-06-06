// Time Complexity : O(S * n) //S is capacity and n is array length
// Space Complexity : O(S * n) //dp array size
// Did this code successfully run on Leetcode : NA
// Any problem you faced while coding this : no


/**
 * 1. Form a DP table with multi dimensional array.
 * 2. For every item find max of (item vol+ last row volume by removing current capacity, last item volume at same index). .
 * 3. return last row last element in the array. 
 */

public class Knapsack01 {

	static int knapSack(int Weight, int wtArr[], int valArr[], int arrLength)
	{
		
		int[][] dp= new int[arrLength+1][Weight+1];
		
		for(int row =1;row <=arrLength;row++) {
			for(int col=1;col<=Weight;col++) {
				
				if(col<wtArr[row-1]) {
					dp[row][col]=dp[row-1][col];
				}else {
					dp[row][col]= Math.max(valArr[row-1]+ dp[row-1][col-wtArr[row-1]],dp[row-1][col]);					
				}
			}
		}
		return dp[arrLength][Weight];
	}

	public static void main(String args[]) {
		int val[] = new int[] { 1,2,6 };
		int wt[] = new int[] { 2,3,5};
		int W = 8;
		int n = val.length;
		System.out.println(knapSack(W, wt, val, n));
	}
}
