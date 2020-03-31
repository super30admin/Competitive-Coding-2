public int solveKnapsack(int[] values, int[] weights, int capacity) {
    // edge cases
    if (capacity <= 0 || weights.length == 0)
      return 0;

    int n = weights.length;
    int[][] dp = new int[n+1][capacity + 1];

    for(int i=0; i <= n; i++) {
      for(int j=1; j <= capacity; j++) {
        if(i==0||j==0){
          dp[i][j]=0;
        }
        else if(weights[i-1] <= j){
          dp[i][j] = Math.max(dp[i-1][j-weights[i-1]]+values[i-1],dp[i-1][j]);
        }
        else{
          dp[i][j] = dp[i-1][j];
        }
      }
    }
    return dp[n][capacity];
  }