/*0/1 Knapsack problem 
 * TC - O (M*N) - M - NUMBER OF WEIGHTS, N - MAX WEIGHT
 *SC - O(M*N)  - using a dp matrix of size m+1 and n+1
 *Ran on leetcode - Problem wasnt present on leetcode, ran on my Eclipse IDE
 */

public class MockInterview {
	public static  int findMaxProfit(int[] weights, int[] values, int maxWeight) {
		int[][] dp = new int[weights.length+1][maxWeight+1];
		
		// first row and first column are zero by default due to initialization above
		for(int i = 1; i < dp.length; i++) {
			for (int j = 1; j <dp[0].length; j++) {
				if (j < weights[i-1]) {
					// if the current max weight is less than the weight the item has to offer 
					dp[i][j] =  dp[i-1][j];  
				} else {
					dp[i][j] = Math.max(dp[i-1][j], values[i-1] + dp[i-1][j-weights[i-1]]); 
				}
				
			}
		}
		
		return dp[dp.length-1][dp[0].length-1]; 
	}
	
	public static void main(String[] args) {
		//System.out.println("Hello");
		int[] weights = new int[] {1,2,3};
		int[] values = new int[] {60,100,120};
		int maxWeight = 5;
		int maxProfit  = findMaxProfit(weights, values, maxWeight);
		
		System.out.println(maxProfit);
	}
}



