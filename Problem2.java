class Solution 
{ 
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
         // your code here 
         int[][] dp=new int[n+1][W+1];
         for(int i=0;i<W+1;i++){
             dp[0][i]=0;
         }
         for(int i=0;i<n+1;i++){
             dp[i][0]=0;
         }
         for(int i=1;i<n+1;i++){
             for(int j=1;j<W+1;j++){
                 if(j-wt[i-1]<0){
                     dp[i][j]=dp[i-1][j];
                 }
                 else{
                  dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-wt[i-1]]+val[i-1]);   
                 }
             }
         }
         return dp[dp.length-1][dp[0].length-1];
    } 
}