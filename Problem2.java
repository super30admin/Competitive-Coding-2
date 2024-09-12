//Time Complexity: O(mn)
//Space complexity: O(mn)

package Mock1;

public class KnapSack {
	
	public static int maxValue(int[] wgh, int[] v, int w)
	{
		int[][] dp = new int[wgh.length+1][w+1];
		
		
		for(int i=1;i<=wgh.length;i++)
		{
			for(int j=1;j<=w;j++)
			{
				if(wgh[i-1]>j)
					dp[i][j] = dp[i-1][j];			//storing all possible sum values in a dynamic matrix.
				else
					dp[i][j] = Math.max(dp[i-1][j-wgh[i-1]]+v[i-1], dp[i-1][j]);	//If the sum is not possible is not adding the previous roe value to present index
			}																	//f sum is possible with that comparing of previous and present value and adding, if requires previous elements help then getting the value from respective index.
		}
		return dp[wgh.length][w];
	}

	public static void main(String []args)
	{
		int []v = {60,100,120};
		int []wgh = {10,20,30};
		int result = maxValue(wgh, v, 50);
		System.out.println(result);
	}
}
