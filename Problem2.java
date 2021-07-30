// KNAP SACK - Dynamic Programming
// Time Complexity = O(M*N)
// Space Complecity = O(M*N)
// M = weights.length W = maxWeight
public class Main
{
	public int knapSack(int[] weights, int[] values, int maxWeight) {
	    
	    if(weights == null || weights.length == 0) {
	        return 0;
	    }
	    
	    int[][] dp = new int[values.length][maxWeight + 1];
	    
	    for(int i = 0; i < values.length; i++) {
	        dp[i][0] = 0;
	    }
	    
	    for(int i = 0; i < values.length; i++) {
	        for(int j = 1; j <= maxWeight; j++) {
	            if(j < weights[i]) {
	                dp[i][j] = dp[i-1][j];
	            } else {
	                dp[i][j] = Math.max(values[i] + dp[i-1][j-weights[i]],dp[i-1][j]);
	            }
	        }
	    }
	    return dp[values.length - 1][maxWeight];
	}
}
