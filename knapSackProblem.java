//Time Complexity: O(n * m) n = number of values; m = number of columns(Capacity)
//Space COmplexity: O(n * m)
public class knapSackProblem {

    public static int knapSack(int W, int[] wt, int[] val, int n) {
        int[][] dp = new int[n + 1][W + 1];


        for(int i = 0; i <= n; i++)
        {
            for(int j = 0; j <= W; j++)
            {
                if(j == 0 || i == 0)
                {
                    dp[i][j] = 0;
                }
                else if(j < wt[i - 1])
                {
                    dp[i][j] = dp[i - 1][j];
                }
                else
                {
                    dp[i][j] = Math.max(val[i - 1] + dp[i - 1][j - wt[i - 1]], dp[i - 1][j]);
                }
            }
        }return dp[n][W];
    }
    public static void main(String args[])
    {
        int val[] = new int[] { 60, 100, 120 };
        int wt[] = new int[] { 10, 20, 30 };
        int W = 50;
        int n = val.length;
        System.out.println(knapSack(W,wt,val,n));
    }

}