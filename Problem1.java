//Knapsack problem
//Time: O(m*n)
//space: O(m*n)

public class Problem1 {
    public static void main(String[] args) {
        int[] w = {10,20,30};
        int[] v = {60,100,120};
       System.out.println(getweights(50,w,v));
    }
    public static int getweights(int capacity, int[] weights, int[] values){
        int n = weights.length;
        int m = capacity;
        if(capacity == 0) return 0;
        if(n==0) return 0;
        if(n==1 ){
            if(weights[0]<capacity){
                return values[0];
            }else{
                return 0;
            }
        }
        int[][] dp = new int[n+1][m+1];
        for(int i =0;i<=m;i++){
            dp[0][i]= 0;
        }
        for(int i =0;i<=n;i++){
            dp[i][0]= 0;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(weights[i-1]>j){
                    dp[i][j] = dp[i-1][j];
                }else{
                   dp[i][j] = Math.max(dp[i-1][j-1], (values[i-1] + dp[i-1][j-weights[i-1]]));
                }
            }
        }
        int result = dp[n][m];
        return result;
    }
}