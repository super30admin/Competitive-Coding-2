// TC:O(n*m) where n is the length of the weight array or price array and m is weight of the knapsack
// SC: O(n*m)
class Solution 
{ 
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
         // your code here 
        int dp [][] = new int[n+1][W+1];
        for(int i =0;i<dp.length; i++){
            for(int j =0;j<dp[0].length;j++){
                dp[i][j] = -1;
            }
        }
        return helper(W, wt, val, n-1, dp);
    } 
    
    public static int helper(int W, int wt[], int val[], int n, int dp[][]){
        if(n <0 || W<=0){
            return 0;
        }
        
        if(dp[n][W] != -1){
            return dp[n][W];
        }
        
        if(W >= wt[n]){
            int incl = val[n] + helper(W - wt[n], wt, val, n-1, dp);
            
            int excl = helper(W, wt, val, n-1, dp);
            
            dp[n][W] =  Math.max(incl, excl);
            
            return dp[n][W];
        }else{
            dp[n][W]=  helper(W, wt, val, n-1, dp);
            return dp[n][W];
        }
    }
}