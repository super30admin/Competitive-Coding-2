/*
 This program uses a bottom-up DP approach to solve the problem. The logic behind the solution is to 
 create a 2D matrix that tracks the maximum value at any capacity m (where 0 < m < capacity) corresponding
 to a certain number of items n (where 1 < n < total items). The solution is thus found by solving this
 repeated subproblem optimally from the beginning when there is just one item, to the end when all the items
 are considered.

 Problems with this code: None
*/



class Solution{
    //Time Complexity = O(capacity * no.of items)
    //Space Complexity = O(capacity * no.of items)
    public int knapsack(int weights[], int values[], int capacity)
    {
        int[][] dp = new int[weights.length + 1][capacity + 1];
        //We create an array to store values for a hypothetical 0th item, to make the DP approach easier and safer
        for(int i = 0; i <= capacity; i++)
            dp[0][i] = 0;
        //We create an array to store values for a hypothetical 0 capacity, to make the DP approach easier and safer
        for(int i = 0; i <= weights.length; i++)
            dp[i][0] = 0;

        for(int i = 1; i < dp.length; i++)
        {
            for(int j = 1; j <= capacity; j++)
            {   //If the weight of the current item is greater than current capacity, we just choose value of previous item at current capacity
                if(weights[i-1] > j)
                    dp[i][j] = dp[i-1][j];
                //We take maximum from the choice of the current item added to the value, or value of the previous item at current capacity
                else
                    dp[i][j] = Math.max(dp[i-1][j], values[i-1] + dp[i][j-weights[i-1]]);
            }
        }
        //The solution is stored at the final location in the 2D matrix
        return dp[weights.length][capacity];
    }

}