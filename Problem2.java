// Time Complexity : O(n*m)
// Sapce Complexity : O(n*m) 

public class Problem2 {
    static int knapSack(int[] wt, int[] val, int capacity)
    {
        if(val.length == 0) return 0;
        int[][] dp = new int[val.length + 1][capacity + 1];
        for(int j = 0; j < dp[0].length; j++)
        {
            dp[0][j] = 0;
        }
        for(int i = 1; i < dp.length; i++)
        {
            for(int j = 1; j < dp[0].length; j++)
            {
                if(j < wt[i - 1])
                {
                    dp[i][j] = dp[i - 1][j];
                }
                else
                {
                    dp[i][j] = Math.max(val[i - 1] + dp[i - 1][j - wt[i - 1]], dp[i - 1][j]);
                }
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }
    public static void main(String args[])
    {
        int[] wt = new int[] {4, 2, 3};
        int[] val = new int[] {10, 15, 40};
        int capacity = 6;
        System.out.println(knapSack(wt, val, capacity));
    }
}