class Solution 
{ 
    // Declaring a 2D array for memoization
    static int[][] memo;

    // Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
        // Initializing the memoization array
        memo = new int[n + 1][W + 1];
        for (int[] row : memo)
            Arrays.fill(row, -1);
        
        return helper(W, wt, val, n, 0, 0);
    } 

    static int helper(int W, int wt[], int val[], int n, int idx, int weight)
    {
        // If the current subproblem is already solved, return its result from memoization array
        if (memo[idx][weight] != -1)
            return memo[idx][weight];
        
        // Base case: if all items are processed or weight capacity is 0
        if (idx == n || W == 0)
        {
            if (weight <= W)
                return memo[idx][weight] = 0;
            else
                return memo[idx][weight] = Integer.MIN_VALUE;
        }

        // Recursive calls to solve subproblems
        int x = helper(W, wt, val, n, idx + 1, weight);
        int y = (weight + wt[idx] <= W) ? val[idx] + helper(W, wt, val, n, idx + 1, weight + wt[idx]) : 0;
        
        // Update memoization array with the maximum of the two options
        return memo[idx][weight] = Math.max(x, y);
    }
}