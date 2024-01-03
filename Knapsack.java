import java.util.Arrays;

public class Knapsack {

    public static int maxProfit(int capacity, int[] profit, int[] weights, int n) {
        if(n == 0 || capacity == 0) return 0;
//        int max = helper(capacity, profit, weights, 0, 0);
        int m = weights.length;
        int c = capacity;
        int[][] dp = new int[m+1][c+1];

        // fill 1st row and 1st column with 0s
        Arrays.fill(dp[0], 0);
        for(int k = 0; k<m; k++ ) {
            dp[k][0] = 0;
        }

        for(int i = 1; i < m+1; i++){
            for(int j = 1; j < c+1; j++){
                if(j < weights[i-1]) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], profit[i - 1]
                            + dp[i - 1][j - weights[i - 1]]);
                }
            }
        }

        System.out.println(Arrays.deepToString(dp));

        return dp[m][c];
//        return max;
    }

    private static int helper(int capacity, int[] profit, int[] weights, int idx, int maxProfit) {
        //base case
        if (capacity == 0 || idx >= weights.length) return maxProfit;
        if (capacity < 0) return 0;

        if(weights[idx] > capacity) {
            return helper(capacity, profit, weights, idx + 1, maxProfit);
        } else {

            //choose
            int case1 = helper(capacity - weights[idx], profit, weights, idx+1, maxProfit + profit[idx]);

            //not choose
            int case2 = helper(capacity, profit, weights, idx + 1, maxProfit);

            return Math.max(case1, case2);
        }
    }

    public static void main(String[] args) {

        int profit[] = new int[] { 10, 15, 40 };
        int weights[] = new int[] { 1, 2, 3 };
        int capacity = 6;

        // Output: 65

        System.out.println(maxProfit(capacity, profit, weights, 3));

    }

}
