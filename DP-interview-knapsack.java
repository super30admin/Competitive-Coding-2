//Knapsack Problem DP approach
//Time: O(m x n)
//Space: O(m x n)

import java.io.*;

class GFG {
    
    
    private static int knapsack(int values[], int weights[], int capacity){
        
        int dp[][] = new int[values.length + 1][capacity + 1];
        
        for (int i=0;i<dp.length;i++){
            
            for(int j=0;j<dp[0].length;j++){
                
                if(i == 0 || j == 0)
                    dp[i][j] = 0;
                
                else if(j>=weights[i-1]){
                    
                    dp[i][j] = Math.max(dp[i-1][j], values[i-1] + dp[i-1][j-weights[i-1]]);
                }
                else{
                    
                    dp[i][j] = dp[i-1][j];
                }
            
                
                
            }
        }
        return dp[values.length][capacity];
        
        
        
        
    }
	public static void main (String[] args) {
		int[] v = {60,100,120};
		int[] w = {10,20,30};
		int c = 50;
		
		int result = knapsack(v,w,c);
		System.out.println(result);
 	}
