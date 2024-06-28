class Solution{
    public int knapSack(int W, int wt[], int val[], int n){
        if(wt == null || wt.length == 0 ){
            return 0;
        }
        int m = wt.length;
        int[][] dp = new int[m+1][W+1];

        for(int i = 0; i < m + 1; i++){
            for( int j = 0; j < W +1; j++){
                if(i == 0 || j==0){
                    dp[i][j] = 0
                }
                int currProfit = val[i-1]; // current item's profit
                int currWeight = wt[i-1]; // current item's weight
                int maxWeight = j; // maximum weight we can carry currently
                if( currWeight >= maxWeight){
                    dp[i][j] = Math.max( currWeight + dp[i-1][maxWeight - currWeight] , dp[i-1][maxWeight] );
                }else{
                    dp[i][j] = dp[i-1][maxWeight]; // copy from above row
                }
            }
        }

        return dp[m+1][W+1];
    }
}