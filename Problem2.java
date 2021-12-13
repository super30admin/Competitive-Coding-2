// Time Complexity : O(N * M) -> where N = length of arrays w and v 
				       M = Caparcity
// Space Complexity : O(N * M)
// Did this code successfully run on Leetcode : did not find question on leetcode
// Any problem you faced while coding this : Was able to figure out recursion solution paritally but did not able to find dp solution without looking at solution video


// Your code here along with comments explaining your approach
/**
 * We use dp array to find maximum value for each caparcity till given caparcity. 
 * We use an extra row of 0. And we fill columns of this row by 0.
 * From row 1 till last row, we calculate value of each cell using this formula:
 * If current column value is less than weight[row - 1] then dp[row][col] = dp[row-1][col].
 * else dp[row][col] = Maximum (dp[row-1][col] and w[row-1] + dp[row][col - w[row-1]])
 * Here in else part, 1st value in maximum resembles profit without choosing current weight and other value
 * resembles value after choosing current weight. So for current cell, we take maximum between them.
 * In last row and last column we will get our ans.
*/


public class Solution{

	public static void main(String[] args) {
		//Inputs
		int[] w = new int[] {2,3,5};
		int[] v = new int[] {1,2,6};
		int cap = 8;
		
		//System.out.println(cal(w,v,cap, 0, 0));
		
		int[][] dp = new int[w.length+1][8+1];
		
		for(int c = 0; c < dp[0].length;c++)dp[0][c] = 0;
		
		for(int r = 1; r < dp.length;r++) {
			for(int c = 0; c < dp[0].length;c++) {
				if(c < w[r-1]) {
					dp[r][c] = dp[r-1][c];
				}else {
					dp[r][c] = Math.max(dp[r-1][c], v[r-1] + dp[r][c - w[r-1]]);
				}
			}
		}
		
		System.out.println(dp[dp.length-1][dp[0].length-1]);
	}
	
	private static int cal(int[] w, int[] v, int cap, int value, int index) {
		//base case
		if(index == w.length || cap == 0)return value;
		
		//logic
		int case1 = cal(w, v, cap, value, index+1);
		
		int case2 = 0; 
		
		if(w[index] <= cap)case2 = cal(w, v, cap - w[index], value + v[index], index+1);
		
		return Math.max(case1, case2);
	}

}
