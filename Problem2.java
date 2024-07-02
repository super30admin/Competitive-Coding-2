// Time Complexity :O(2^n)
// Space Complexity :O(mxn)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
// Using recursion for taking the eight and not takingthe weight and finally taking the max profit it can generate in both cases


class Solution 
{ 
    int memo[][];
    public void printMemo(){
        for(int i = 0;i<this.memo.length;i++){
             for(int j=0;j<this.memo[0].length;j++){
                 System.out.print(this.memo[i][j]+" ");
             }
             System.out.println();
         }
        System.out.println("**********");
    }
    public int helper(int W, int[] wt, int[] val, int n, int idx){
        
        if(idx>=n) return 0;
        if(W == 0) return 0;
        if(W<0) return -99999;
        
        if(this.memo[idx][W]!=-1) return this.memo[idx][W];
        
        int case1 = 0 + helper(W, wt, val, n, idx + 1);
        int case2 = 0;
        if(W >= wt[idx]) case2 = val[idx] + helper(W-wt[idx], wt,val, n, idx + 1);
        
        int max = Math.max(case1, case2);
        
        this.memo[idx][W] = max;
        //this.printMemo();
        return max;
    }
    //Function to return max value that can be put in knapsack of capacity W.
    int knapSack(int W, int wt[], int val[], int n) 
    { 
         // your code here 
         this.memo = new int[n][W+1];
         for(int i = 0;i<n;i++){
             for(int j=0;j<W+1;j++){
                 memo[i][j] = -1;
             }
         }
        //  int maxProfit = Integer.MIN_VALUE;
        //  for(int i=0;i<n;i++){
        //      maxProfit = Math.max(helper(W,wt,val,n, i),maxProfit);
        //  }
         return helper(W,wt,val,n, 0);
         
    } 
}

// Time Complexity :O(mxn)
// Space Complexity :O(mxn)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
//Minding the maximum profit between Max(profit[weight(j) - currentWeight(i)] + profit[i], profit[i-1](previous))


class Solution 
{ 
    //Function to return max value that can be put in knapsack of capacity W.
    int knapSack(int W, int wt[], int val[], int n) 
    { 
         // your code here
         int[][] dp = new int[n+1][W+1];
         for(int i=1;i<n+1;i++){
                for(int j=1;j<W+1;j++){
                 if(j<wt[i-1]){
                     dp[i][j] = dp[i-1][j];
                 }else if(j-wt[i-1]==0){
                     dp[i][j] = Math.max(val[i-1], dp[i-1][j]);
                 }else {
                     dp[i][j] = Math.max(val[i-1]+dp[i-1][j-wt[i-1]], dp[i-1][j]);
                 }
             }
         }
         return dp[n][W];
    } 
}
  

