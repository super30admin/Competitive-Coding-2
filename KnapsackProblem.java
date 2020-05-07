package s30Coding;

//Time Complexity : O(n*m) where n is the size of array and m is the capacity
//Space Complexity: O(n*m) where n is the size of array and m is the capacity

public class KnapsackProblem {
	public static int knapSack(int capacity, int weight[], int profit[]) { 
			if(weight == null || weight.length == 0) {
				return 0;
			}
			     int size = weight.length;
			     int dp[][] = new int[size+1][capacity+1];  
			     for (int i = 0; i <= size; i++)
			     { 
			         for (int c = 0; c <= capacity ; c++)
			         { 
			             if (i==0 || c==0) {
			                  dp[i][c] = 0; 
			             }
			             else if (weight[i-1] >= c) { 
			                   dp[i][c] = Math.max(profit[i-1] + dp[i-1][c-weight[i-1]],  dp[i-1][c]); 
			             }
			             else {
			            	 dp[i][c] = dp[i-1][c]; 
			             }
			                   
			         } 
			      } 
			       
			      return dp[size][capacity]; 
			   } 
}
