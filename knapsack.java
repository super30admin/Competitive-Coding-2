// Time Complexity : O(n*W) where W is the capacity
// Space Complexity : O(n*W)

//CODE

class knapsack {
    static int knapSack(int capacity, int[] wt, int[] val, int n) {
        int a = wt.length;
        int b = capacity;

        int[][] dp = new int[a + 1][b + 1];
        // Filling dp[][] matrix
        for (int i = 1; i <= a; i++) {
            for (int j = 1; j <= b; j++) {
                if (wt[i - 1] > j) { // getting value from above row till j is less than i-1th row
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], val[i - 1] + dp[i - 1][j - wt[i - 1]]);
                }
            }
        }

        int result = dp[dp.length - 1][dp[0].length - 1];
        return result;
    }

    public static void main(String args[]) {
        int val[] = new int[] { 60, 100, 120 };
        int wt[] = new int[] { 10, 20, 30 };
        int W = 50;
        int n = val.length;
        System.out.println(knapSack(W, wt, val, n));
    }
}