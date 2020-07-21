class Solution{
    public int calculate(int[] values, int[] weights, int capacity){
        int[][] dp = new int[weights][(capacity/10)+1];
        int column = (capacity/10)+1;
        for(int i=0; i<weights.length; i++){
            for(int j=0; j<column; j++){
                if(weights[i] == (j*10)){
                    dp[i][j] = Math.max((values[i]+dp[i][(j*10)-weights[i]]), values[j]);
                }
                else if((j*10)<weights[i]){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = Math.max((values[i]+dp[i][(j*10)-weights[i]]), dp[i-1][j]);
                }
            }
        }
        return dp[weights.length][column];
    }
}