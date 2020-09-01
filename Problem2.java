
public class KnapSack {

    static int KnapSack(int val[], int[] weight, int capacity, int n) {

        int[][] dp = new int[n + 1][capacity + 1];

        for (int i = 0; i <= n; i++) {
            {
                for (int j = 0; j <= capacity; j++)
                    if (i == 0 || j == 0)
                        dp[i][j] = 0;
                    else if (j >= weight[i - 1]) {
                        dp[i][j] = Math.max(val[i - 1] + dp[i - 1][j - weight[i - 1]], dp[i - 1][j]);

                    } else {// get it from top
                        dp[i][j] = dp[i - 1][j];
                    }
            }
        }
        return dp[n][capacity];

    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        int[] val = new int[] { 60, 100, 200 };
        int[] weight = new int[] { 10, 20, 30 };
        int capacity = 50;
        System.out.println(KnapSack(val, weight, capacity, val.length));
    }

}
