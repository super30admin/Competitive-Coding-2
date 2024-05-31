T.c --> O(n*w)
S.c --> O(n*w)

class Solution 
{ 
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
        
        int[][] dp = new int[n+1][W+1];
        
        for(int i=0 ; i<n+1; i++){
         for(int j =0; j<W+1; j++){
            if (i == 0 || j == 0)
                dp[i][j] = 0;
            else if(wt[i-1] > j){
                dp[i][j] = dp[i-1][j];
            }else{
                dp[i][j] = Math.max(dp[i-1][j], val[i-1]+dp[i-1][j-wt[i-1]]);
            }  
         }
        }
        
        return dp[n][W];
    } 
}

