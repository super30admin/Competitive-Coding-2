class Problem2 {


    static int knapSack(int W, int wt[], int val[], int n) {

        int[][] dp= new int[n+1][W+1];

        //build table dp[]][] in bottom up manner
        for (int i=0;i<=n;i++)
        {
            for (int w=0;w<=W;w++)
            {
                if (i==0 || w==0)
                {
                    dp[i][w]=0;
                }
                else if (wt[i-1]<=w)
                {
                    dp[i][w]= Math.max(dp[i-1][w], val[i-1]+ dp[i-1] [w-wt[i-1]] );
                }
                else {
                    dp[i][w]= dp[i-1][w];
                }
            }
        }
        // Print the dp array
        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= W; w++) {
                System.out.print(dp[i][w] + " ");
            }
            System.out.println(); // Move to the next row
        }

        return dp[n][W];


    }
    public static void main(String args[]) {
        int profit[] = new int[] { 1,2,5,6 };
        int weight[] = new int[] {2,3,4,5};
        int W = 8;
        int n = profit.length;
        System.out.println(knapSack(W, weight, profit, n));
    }
}