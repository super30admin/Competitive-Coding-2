//Time: O(values.length * weights.length)
//Space: O(values.length * weights.length)
//ran on leetcode
//concept was difficult but coding was ok

public class KnapSack {

    public static int knap_sack(int capacity, int weights[],
                                int values[])
    {
        int i, j;
        int dp[][] = new int[values.length + 1][capacity + 1];

        //fill dp matrix
        for (i = 0; i <= values.length; i++)
        {
            for (j = 0; j <= capacity; j++)
            {
                //fill in top w/zero
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
                else if (weights[i - 1] <= j)
                    //optimized value for current spot based on previous row (like coin change 2)
                    dp[i][j]
                            = Math.max(values[i - 1]
                                    + dp[i - 1][j - weights[i - 1]],
                            dp[i - 1][j]);
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }

        return dp[values.length][capacity];
    }
    public static void main(String[] args) {
        int val[] = new int[] { 60, 100, 120 };
        int wt[] = new int[] { 10, 20, 30 };
        int W = 50;
        System.out.println(knap_sack(W, wt, val));
    }
}