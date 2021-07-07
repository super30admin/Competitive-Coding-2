//Time Complexity:O(N*W) where N is number of items and W is capacity
//Space Complexity:O(N*W) where N is number of items and W is capacity

public class Problem2 {
    static int max(int a, int b)
    {
        return (a > b) ? a : b;
    }

    static int knapSack(int W, int wt[], int val[], int n)
    {

        int[][] dp = new int[n+1][W+1];
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(j>=wt[i-1])
                    dp[i][j] = max(dp[i-1][j],dp[i-1][j-wt[i-1]]+val[i-1]);
                else
                    dp[i][j]= dp[i-1][j];
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }

    // Driver code
    public static void main(String args[])
    {
        int val[] = new int[] { 60, 100, 120 };
        int wt[] = new int[] { 10, 20, 30 };
        int W = 50;
        int n = val.length;
        System.out.println(knapSack(W, wt, val, n));
    }
}
