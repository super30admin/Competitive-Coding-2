class Knapsack{
    //    public static int knapSack(int W, int wt[], int val[], int n) {
    //        // base
    //        if(W == 0 || n == 0) return 0;
    //
    //        if(wt[n-1] > W) return knapSack(W , wt, val, n-1);
    //        //logic
    //        int case1 = val[n-1] + knapSack(W - wt[n-1], wt, val, n-1);
    //        int case2 = knapSack(W , wt, val, n-1);
    //        return Math.max(case1, case2);
    //    }

    public static int knapSack(int W, int wt[], int val[], int n) {
        int[][] dp = new int[wt.length+1][W+1];

        //fill dp
        for(int i=0; i< dp.length; i++){
            dp[i][0] = 0;
        }
        for(int j=0; j<dp[0].length; j++){
            dp[0][j] = 0;
        }

        //logic
        for(int i=1; i<dp.length; i++){
            for(int j=1; j<dp[0].length; j++){
                if(wt[i-1] <= j)
                    dp[i][j] = Math.max(val[i-1] + dp[i-1][j - wt[i - 1]], dp[i-1][j]);
                else
                    dp[i][j] = dp[i-1][j];
            }
        }

        return dp[dp.length-1][dp[0].length-1];
    }


    public static void main(String args[])
    {
        int val[] = new int[] { 10, 15, 40 };
        int wt[] = new int[] { 1, 2, 3 };
        int W = 6;
        int n = val.length;
        System.out.println(knapSack(W, wt, val, n));
    }
}