// Approach : bottom up dynamic programming
// Time Complexity : O(w*c) where w is the number of weights and c is the capacity
// Space Complexity : O(w*c)
using System;

public class GFG{
	static public void Main (){
		//Code
		int[] weights = new int[]{10, 20, 30};
		int[] values = new int[]{100, 60, 120};
		
		int maxValue = MaxValue(weights, values, 50);
		
		System.Console.WriteLine("Max value we can get from picking weights within capacity is: "+ maxValue);
	}
	
	public static int MaxValue(int[] weights, int[] values, int capacity){
	    
	    int[,] dp = new int[weights.Length+1, capacity+1];
	    
	    for(int i=1; i<= weights.Length; i++){
	        for(int j=1; j<=capacity; j++){
	            int notselect = dp[i-1, j];
	            
	            int select = j< weights[i-1] ? 0 : dp[i-1, j-weights[i-1]];
	            select = values[i-1] + select;
	            
	            dp[i,j] = Math.Max(select, notselect);
	        }
	    }
	    
	    return dp[weights.Length, capacity];
	}
}
