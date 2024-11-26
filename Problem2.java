// Time Complexity : O(m*n) where m is length of weights array and n is capacity
// Space Complexity :O(m*n) 
// Did this code successfully run on Leetcode : Not on leetcode
// Any problem you faced while coding this : No

//Knapsack problem
public class Problem2{
    
    private static int knapsack(int[] weights, int[] values, int capacity)
    {
        int[][] dp = new int[values.length+1][capacity+2];
        for(int i=0;i<dp.length;i++)
        {
            for(int j=0;j<dp[0].length;j++)
            {
				//First row will have weight = 0 
				//First column will have weight = 0 
				//Populate 0 for when i=0 or j=0
                if(i==0||j==0)		
                    dp[i][j]=0;
                else if(weights[i-1]<j)
                {
					//value will be Max(value of current weight is picked + value of the difference , value is current weight is not picked)
                    dp[i][j]=Math.max(dp[i-1][j-weights[i-1]]+values[i-1],dp[i-1][j]);
                }
            }
        }

        return dp[dp.length-1][dp[0].length-1];
    }

     public static void main(String []args){
        // int[] weights = {1,3,4,5};
        // int[] values = {1,4,5,7};
        // int capacity = 7;
        
        int values[] = new int[] { 60, 100, 120 }; 
        int weights[] = new int[] { 10, 20, 30 }; 
        int capacity = 50; 
        System.out.println(knapsack(weights, values, capacity));
     }
}