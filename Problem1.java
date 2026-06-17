// Time Complexity: O(m*n)
// SpaceComplexity: O(m*n)
class Knapsack {
    public int knapsack(int W, int val[], int wt[]) {

        int m= wt.length;
        int n = W;

        int [][] dp = new int [m+1][n+1];

        for(int i = 1; i<=m; i++){
            int weight = wt[i-1];
            for(int j= 0; j<=n; j++) {
                if(j < weight) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], val[i-1]+dp[i-1][j-weight]);
                }
            }
        }
        return dp[m][n];
    }
}