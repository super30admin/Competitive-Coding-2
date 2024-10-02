//TC: O(n * W), where n is the number of items and W is the capacity of the knapsack.
//SC: O(n * W) space can be optimized by 1D array for the DP table.

using System;
using Knapsack;

public class program
{
    static public void Main()
    {
        Solution obj = new Solution();
        ExhaustiveApproach ea = new ExhaustiveApproach();
        int[] profits = new int[] { 1, 2, 3 };
        int[] weights = new int[] { 4, 5, 1 };
        int capacity = 4;
        //int result = obj.Knapsack(profits, weights, capacity);
        int result = ea.Knapsack(profits, weights, capacity,0,0);
        Console.WriteLine(result);
    }
}

public class Solution
{
    public int Knapsack(int[] profits, int[] weights, int capacity)
    {
        int n = profits.Length;


        int[,] dp = new int[n + 1, capacity + 1];

        for (int i = 1; i <= n; i++)
        {
            for (int w = 1; w <= capacity; w++)
            {
                // case where, if weight of current item is greater than the remaining capacity,then cannot take this item
                if (weights[i - 1] <= w)
                {
                    // two options here: take it or leave it
                    dp[i, w] = Math.Max(dp[i - 1, w], dp[i - 1, w - weights[i - 1]] + profits[i - 1]);
                    //dp[i - 1, w - weights[i - 1]] : i-1 is the previous row, no choose case comes from previous row,
                    //bcoz we cant choose that weight again
                }
                else
                {// no choose case
                    // Leave the item if its weight exceeds the current capacity
                    dp[i, w] = dp[i - 1, w];
                }
            }
        }


        return dp[n, capacity];
    }
}
