/*
TC: O(mn) where m is row n is col
SC: O(N) for matrix
 */
class KnapSackBottomUp{

    private int KnapSack(int[] weights, int[] values, int W){
        int dp[][] = new int[values.length+1][W+1];

        for (int i = 1; i < dp.length; i++){
            for (int i = 1; i < dp[0].length; i++){
                if (weights[i-1] <= W){
                    dp[i][j] = Math.max(values[i-1] + dp[i-1][j - weights[i-1]], dp[i-1][j]);
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[dp.length-1][dp[0].length-1];
    }
}