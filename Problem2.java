// Time Complexity = O(M*N) M = 0->values and N = 0 -> maxWeight
// Space Complecity = O(M*N) M = 0->values and N = 0 -> maxWeight

public class Problem2 {

    public static void main(String[] args) {
        int values[] = new int[] { 10, 15, 40 };
        int weights[] = new int[] {1, 2, 3};
        int maxWeight = 6;
        System.out.println(knapSack(weights, values, maxWeight));
    }

    public int knapSack(int[] weights, int[] values, int maxWeight) {

        if(weights == null || weights.length == 0) {
            return 0;
        }

        int n = values.length;

        int[][] dp = new int[n+1][maxWeight + 1];

        for(int i = 0; i < n; i++) {
            dp[i][0] = 0;
        }

        for(int i = 0; i < n; i++) {
            for(int j = 1; j <= maxWeight; j++) {
                if(j < weights[i]) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = Math.max(values[i] + dp[i-1][j-weights[i]],dp[i-1][j]);
                }
            }
        }
        return dp[n - 1][maxWeight];
    }
}