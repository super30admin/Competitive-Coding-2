//Solved using DP approach
// Time Complexity : O(mxn) => m => number of available weights, n => Capacity
//Space Complexity: O(mxn)

int knapSack(int capacity, int weight[], int profit[]) 
{ 
    int n = sizeof(weight) / sizeof(weight[0]); 

    vector<vector<int> > dp(n + 1, vector<int>(capacity + 1)); 
  
    for (int i = 0; i <= n; i++) 
    { 
        for (int j = 0; j <= capacity; j++) 
        { 
            if (i == 0 || j == 0) 

                dp[i][j] = 0; 
            else if (weight[i - 1] <= j) 
                dp[i][j] = max(profit[i - 1] 
                                  + dp[i - 1][j - weight[i - 1]], 
                              dp[i - 1][j]); 
            else
                dp[i][j] = dp[i - 1][j]; 
        } 
    } 
    return dp[n][capacity]; 
} 