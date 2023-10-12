// Knapsack 0-1 Problem
//Solved using recursion, give TLE on geeksforgeeks
/*
class Solution 
{ 
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
      int result = Integer.MIN_VALUE;
      result = Math.max(result, helper(wt, val, 0, 0, 0, W));
      return result;
    } 
    
    public static int helper(int[] wt, int[] val, int index, int total_wt, int total_val, int W)
    {
     
     //base
     if(total_wt >= W || index == wt.length) return total_val;
     
     //case 1 - choose
     int casefirst = helper(wt, val, index + 1, total_wt + wt[index], total_val + val[index], W );
     
     //case 2 - not choose 
     int casetwo = helper(wt, val, index + 1, total_wt, total_val, W );
        
    return Math.max(casefirst, casetwo);    
    
    }
}
*/

// solve using DP
// WE create a 2D array, in which we store the weight horizontally and values obtained in the row
//with the first row, we fill using with weights row 0 as 0 and weights column 0 as 0
// and we fill each cell with formula Math.max(values[i-1] + dp[i-1][j-(weights[i-1])], dp[i-1][j])

// Time Complexity : O(M*N) where M is number of items and N is max weight
// Space Complexity : O(M*N) where M is number of items and N is max weight

class Problem2 {

    public static void main(String args[])
    {
        int result = knapsackDP();
        System.out.println("Maximum weight is " + result);
    }

    public static int knapsackDP()
    {
        int[] values = new int[]{20, 5, 10, 40, 15, 25};
        int[] weights = new int[]{1, 2, 3, 8, 7, 4 };
        int maxWeight = 10;
        int r = weights.length+1, c = maxWeight+1;

        int[][] dp = new int[weights.length+1][maxWeight+1];

        for(int i = 1; i < r; i++)
        {
            for(int j = 0; j < c; j++)
            {
                if(weights[i-1] > j)
                    dp[i][j] = dp[i-1][j];
                else
                    dp[i][j] = Math.max(values[i-1] + dp[i-1][j-(weights[i-1])], dp[i-1][j]);
            }
        }
        return dp[r-1][c-1];
    }
}


