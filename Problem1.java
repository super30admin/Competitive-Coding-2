//Approach: The problem can be solved using exhaustive method like regression but since there are repeated subproblems,
// we could use the tabulation dynamic programming approach significiantly reducing the time complexity
//Time Complexity: O(mxn)
//Space Complexity: O(mxn)
public class KnapSack
{
    public int knapsack(int W, int[] val, int[] wt)
    {
        //Add validations for input
        if (val == null || val.length == 0 || wt == null || wt.length == 0 || val.length != wt.length)
        {
            return 0;
        }

        int m = wt.length;
        int n = W;
        int[][] dp = new int[m+1][n+1];

        for (int i=1; i <= m; i++)
        {
            for (int j = 1; j <= n; j++)
            {
                if (j < wt[i-1]){
                    dp[i][j] = dp[i-1][j]; //No Choose case
                }
                else {
                    dp[i][j] = Math.max(dp[i-1][j], val[i-1]+dp[i-1][j-wt[i-1]]); //Choose case
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args){
        KnapSack k = new KnapSack();
        int i = k.knapsack(50, new int[]{60, 100, 120}, new int[]{10, 20, 30});
        System.out.println(i);
    }
}