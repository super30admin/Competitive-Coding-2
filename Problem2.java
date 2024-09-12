//0/1 knapsack

// Time Complexity : O(n * W) where n is the size of arrays and W the max possible weight
// Space Complexity : O(n * W)
// Did this code successfully run on Leetcode : NA
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//We have an optimal substructure here, for each element we either select the element or not
//We will write the recursive funtion where we take max of either select or not select
//A 2D array of sixe n * W would help us store the result of the particular combination in the cell
//Through bottom up approach we will keep filling the 2D array and return the last value in the 2D array as our result.
class Knapsack {
	static int max(int a, int b)
	{
		return (a > b) ? a : b;
	}
	static int knapSack(int W, int wt[],
						int val[], int n)
	{
		int i, w;
		int K[][] = new int[n + 1][W + 1];
		for (i = 0; i <= n; i++)
		{
			for (w = 0; w <= W; w++)
			{
				if (i == 0 || w == 0)
					K[i][w] = 0;
				else if (wt[i - 1] <= w)
					K[i][w]= max(val[i - 1] + K[i - 1][w - wt[i - 1]],K[i - 1][w]);
				else
					K[i][w] = K[i - 1][w];
			}
		}
		return K[n][W];
	}
	public static void main(String args[])
	{
		int val[] = new int[] { 60, 100, 120 };
		int wt[] = new int[] { 10, 20, 30 };
		int W = 50;
		int n = val.length;
		System.out.println(knapSack(W, wt, val, n));
	}
}
