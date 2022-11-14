// Time complexity is O(M*N)
//Space complexity is O(M*N)
public class Knapsack {

    static int knapSack(int W, int weights[],
                        int values[], int n)
    {
        int i, w;
        int dp[][] = new int[n + 1][W + 1];
 
        for (i = 0; i <= n; i++)
        {
            for (w = 0; w <= W; w++)
            {
                if (i == 0 || w == 0)
                    dp[i][w] = 0;
                else if (weights[i - 1] <= w)
                    dp[i][w]
                        = Math.max(values[i - 1]
                         + dp[i - 1][w - weights[i - 1]],
                         dp[i - 1][w]);
                else
                    dp[i][w] = dp[i - 1][w];
            }
        }
 
        return dp[n][W];
    }
 
    public static void main(String args[])
    {
        int values[] = new int[] { 60, 100, 120 };
        int weights[] = new int[] { 10, 20, 30 };
        int W = 50;
        int n = values.length;
        System.out.println(knapSack(W, weights, values, n));
    }
}