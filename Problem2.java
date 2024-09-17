// Recursive Solution: 
// Time complexity: O(2^N), where N is the length of wt array, each element has two options choose and not choose.  
// Space complexity: O(N), maximum depth of recursive calls. 

// DP Solution:  
// Time complexity: O(N*W), where N is the length of wt array and W is the capacity of the knapsack.  
// Space complexity: O(N*W). 

class Solution 
{
    // recursive solution
    static int helper(int wt[], int val[], int W, int V, int i, int n) {
        // base
        if(i == n || W <= 0) {
            return V; 
        }
        // choose
        int case1 = W>=wt[i]?helper(wt, val, W-wt[i], V+val[i], i+1, n):0;
        // don't choose
        int case2 = helper(wt, val, W, V, i+1, n);
        
        return Math.max(case1, case2); 
    }
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
         // your code here 
         //  return helper(wt, val, W, 0, 0, n); 
        
        //  dp solution
        int dp[][] = new int[n+1][W+1];
        
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=W; j++) {
                if (wt[i - 1] > j) {
                    dp[i][j] = dp[i-1][j]; 
                }
                else {
                    // max of choose and don't choose
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-wt[i-1]] + val[i-1]); 
                }
            }
        }
        
        return dp[n][W];
        
    } 
}