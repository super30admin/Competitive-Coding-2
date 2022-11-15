class SOlution{
    public int knapSack(int[] weight, int[] values, int capacity){
        int[][] dp=new int[values.length+1][capacity+1];
        for(int i=1;i<=values.length;i++){
            for(int j=1;j<=capacity;j++){
                if(j<weight[i-1]){
                    dp[i][j]= dp[i-1][j];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j],values[i-1]+dp[i-1][j-weight[i-1]]);
                }
            }
        }
        return dp[capacity][values.length];
    }
}