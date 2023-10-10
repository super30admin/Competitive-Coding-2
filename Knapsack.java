// Time Complexity : O(M*N) where M is number of items and N is max weight
// Space Complexity : O(M*N) where M is number of items and N is max weight
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Knapsack {
    public int knapsackDP()
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

    public int knapsack()
    {
        int[] values = new int[]{20, 5, 10, 40, 15, 25};
        int[] weights = new int[]{1, 2, 3, 8, 7, 4 };
        int maxWeight = 10;

        return helper(values, weights, maxWeight, 0, maxWeight, 0);
    }
    public int helper(int[] values, int[] weights, int maxWeight, int idx, int remainingWeight, int totalValue)
    {
        // base
        if(remainingWeight < 0)
            return 0;
        else if ( idx >= weights.length)
            return totalValue;
        else if(remainingWeight == 0)
            return totalValue;

        // logic
        int weightAfterInclude = remainingWeight-weights[idx];
        int valueAfterInclude = totalValue + values[idx];

        int include = Math.max(totalValue, helper( values, weights, maxWeight, idx+1, weightAfterInclude, valueAfterInclude));
        int exclude = Math.max(totalValue, helper( values, weights, maxWeight, idx+1, remainingWeight, totalValue ) );

        // return
        return Math.max(include, exclude);
    }


}
