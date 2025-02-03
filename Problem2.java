
//using recursion 
//Time complexity o(2n)
// space complexity o(n)
class Solution {
    private int remainingCap;
    
        // Function to return max value that can be put in knapsack of capacity.
        public int knapSack(int capacity, int val[], int wt[]) {
            return helper(wt,val,capacity,0);
        
        }
        
        private int helper(int wt[], int val[],int remaingCap, int idx){
            
            if(idx == wt.length || remainingCap == 0) return 0;
        if(wt[idx]>remainingCap){
            return helper(wt,val,remainingCap,idx + 1);
        }
        
        int case1 = helper(wt,val,remainingCap,idx + 1);// no choose case

        int case2 = helper(wt,val,remainingCap-wt[idx],idx);// choose case
        
        return Math.max(case1,case2);
    }
    
}


//using dp
// Time complexity o(m*n)
// space complexity o(m*n)

class Solutions{
    public int knapSack(int capacity, int val[], int wt[]) {
        int[] profit = {60,100,120};
        int m = wt.length;
        int n = capacity;

        int [][] dp = new int[m+1][n+1];
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(wt[i-1]>j){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], profit[i-1] + dp[i-1][j-wt[i-1]]);
                }
            }
        }
        return dp[m][n];
    }
}