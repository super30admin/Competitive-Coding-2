// Time complexity is O(m*n)
// Space complexity is O(m*n)

public class BigN29KnapsackWeightAndValue {
	public int solutionFinder(int [] weights, int [] values, int capacity) {
		// edge case
		if (weights.length ==0 || weights == null || values.length ==0 || values == null)
			return -1;
		int row = weights.length;
		int column = capacity+1;
		int [][] dp = new int[row][column];
		for (int i = 0; i<row;i++) {
			dp[i][0] =0;
		}
		for (int j = 0;j<column;j++) {
			dp[0][j] =0;
		}
		for (int i =1;i<row;i++) {
			for(int j = 0;j<column;j++) {
				if(j<weights[i]) {
					dp[i][j] = dp[i-1][j];
				}
				else {
					dp[i][j] = Math.max(values[i]+ dp[i-1][j-weights[i]], dp[i-1][j]);
				}
			}
		}
		return dp[row-1][column-1];
	}
	public static void main(String [] Args) {
		BigN29KnapsackWeightAndValue knapsack = new BigN29KnapsackWeightAndValue();
		int [] weights = {10,20,30}; 
		int [] values = {60,100,120};
		int capacity = 50;
		System.out.println(knapsack.solutionFinder(weights, values, capacity));
	}
}
