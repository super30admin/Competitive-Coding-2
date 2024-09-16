// Time Complexity : 0(mn)
// Space Complexity : 0(mn)
class Knapsack {
    public int maxValue(int[] weights, int max_capacity, int[] values) {
        if (weights == null || weights.length == 0) return 0;
        if (values == null || values.length == 0) return 0;

        int dp[][] = new int[weights.length+1][max_capacity+1];
        for(int j=1; j < dp[0].length; j++) {
            dp[0][j] = 0;
        }
        for(int i = 1; i< dp.length; i++) {
            for(int j = 1; j < dp[0].length; j++) {
                if(j < weights[i-1]) {
                    dp[i][j] = dp[i-1][j];
                }
                else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-weights[i-1]] + values[i]);
                }
            }
        }
        int result = dp[dp.length -1][dp[0].length - 1];
        return result;
    }
}