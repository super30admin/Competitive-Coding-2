class MaxValue {
    public static int findMax(int[] weights,int[]values,int capacity){
        int m = weights.length;
        int [][] dp = new int[m+1][capacity+1];
        for(int j=0;j<=capacity;j++){
            dp[0][j] = 0;
        }
        for(int i=1;i<=m;i++){
            for(int j=0;j<=capacity;j++){
                if(weights[i-1]>j){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-weights[i-1]]+values[i-1]);
                }
            }
        }
        return dp[m][capacity];
    }

    public static void main(String[] args) {
        int[] weights = new int[]{10,20,30,40};
        int[] values = new int[]{60,100,120,80};
        System.out.println(MaxValue.findMax(weights,values,50));
    }
}
