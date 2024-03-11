//tc = o(m*n)
//sc = o(m*n)

public class KnapsackBottomUp {
    public int knapsack(int[] wt,int[] val,int capacity){
        int m = wt.length;
        int n = capacity;
        int[][] dp = new int[m+1][n+1];

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(j < wt[i-1]){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j],val[i-1] + dp[i-1][j-wt[i-1]]);
                }
            }
        }
        return dp[m][n];
    }
    public static void main(String[] args) {
        int[] wt = {1,3,4,5};
        int[] val = {1,4,5,7};
        int capacity = 7;
        KnapsackBottomUp k = new KnapsackBottomUp();
        System.out.println(k.knapsack(wt,val,capacity));

    }
}
