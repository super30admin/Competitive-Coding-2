/*
Problem: https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/
Time Complexity: O(w*c) where w is number of weight elements and c is the capacity
Space Complexity: O(w*c) where w is number of weight elements and c is the capacity
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no
// Your code here along with comments explaining your approach

*/

import java.util.*;

public class BagWeight {

public static int BagWeight(int c, int w[],
						int n[], int value)
	{
		
		int dp[][] = new int[value + 1][c + 1];

		//  dp array in bottom up approach
		for (int i = 0; i <= value; i++)
		{
			for (int j = 0; j <= c; j++)
			{
				if (i == 0 || j == 0)
					dp[i][j] = 0;
				else if (w[i - 1] <= j)
					dp[i][j]
						= Math.max(n[i - 1]
						+ dp[i - 1][j - w[i - 1]],
						dp[i - 1][j]);
				else
					dp[i][j] = dp[i - 1][j];
			}
		}

		return dp[value][c];
	}

	// main class
	public static void main(String args[])
	{
		int n[] = new int[] { 10,15,40 };
		int w[] = new int[] { 1, 2, 3 };
		int c = 6;
		int value = n.length;
		System.out.println(BagWeight(c, w, n, value));
	}
}