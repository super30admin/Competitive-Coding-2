//Time and space O(n*m), O(n*m)

public void maxValue(int[] weights, int[] value, int capacity){
      int[][] dp = new int[capacity][weights.length+1];
      for(int i=0; i<capcity;i++){
          dp[0][i]=0;
      }
      for(int i=1; i<capacity; i++){
          for(int j=0; j<weights.length+1; j++){
              if(j<weights[i-1]){
                  dp[i][j]=dp[i-1][j];
              }else{
                  dp[i][j]= Math.max(dp[i-1][j], dp[i-1][j-weights[i-1]]+value[i-1]);
              }
              
          }
      }
      return dp[capacity-1][weights.length];
  }
}
