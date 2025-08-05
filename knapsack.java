/**time complexity: O(m*n)
 * space complexity: O(m*n)
 * where m is the number of items and n is the capacity of the knapsack
 * Did you run the code on geeksforgeseks? Yes
 * Did you face any issues while coding? No
 */

/**
 * Here we are using a dp matrix since for calculating the maximum value when a given weight is chosen might required the previously computed values and hence I am storing the values in a matrix.In this case the index that needs to be accessed from the previously computed values depends on the W at each point and wt[i-1] values which can vary.
 * When we choose a weight we add the value of that weight to the maximum value obtained from the remaining weights.
 * If we do not choose the weight, we simply carry forward the maximum value obtained without including the current weight.
 * In this way, we build up the solution using previously computed values and finally return the maximum value that can be obtained with the given capacity of the knapsack.
 */


class knapsack {
    static int knapsack(int W, int val[], int wt[]) {
        // code here
        
        int m=val.length;
        
        int[][] dp=new int[m+1][W+1];
        
      
        for (int i=1;i<=m;i++)
        {
            for(int j=1;j<=W;j++)
            {
                if(j>=wt[i-1])
                    {  
                        dp[i][j]=Math.max(dp[i-1][j],val[i-1]+dp[i-1][j-wt[i-1]]);
                        
                    }
                else
                    {
                        dp[i][j]=dp[i-1][j];
                    }
            }
               
        }
        return dp[m][W];
        
    }
}
