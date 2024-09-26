/**
Problem 1: Knapsack problem
 
Time Complexity :   O (N*W)
Space Complexity :  O (N*W)
Did this code successfully run on Leetcode :    Yes ()
Any problem you faced while coding this :       No
 */

 class KnapSack{
    static int knapSack(int W, int wt[], int val[], int n)
    {
        // making and initializing dp array
        int[][] dp = new int[n+1][W + 1];

        for (int i = 1; i <= n ; i++) {
            for (int w = 1; w <= W; w++) {

                // included case
                if (wt[i - 1] <= w){
                    // finding the maximum value
                    dp[i][w] = Math.max(dp[i-1][w], dp[i-1][w - wt[i - 1]] + val[i - 1]);
                }
                // not include case
                else{
                    dp[i][w] =  dp[i-1][w];
                }    
            }
        }
        return dp[n][W]; // returning the maximum value of knapsack
    }

    // Driver code
    public static void main(String[] args)
    {
        int val[] = { 60, 100, 120 };
        int wt[] = { 10, 20, 30 };
        int W = 50;
        int n = val.length;
        System.out.print(knapSack(W, wt, val, n));
    }
}
