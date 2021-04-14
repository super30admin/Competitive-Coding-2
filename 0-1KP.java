// TC = O(N * W)
// SC = O(N * W)
public class HelloWorld{
    private static int Knapsack(int[] wt, int[] val, int W){
        int n = val.length;
        int[][] dp = new int[n+1][W+1];
        for(int i = 0 ; i < n+1 ; i++){
            for(int j = 0 ; j < W+1 ; j++){
                if(i==0 || j == 0){
                    dp[i][j] = 0;
                }
                else if(wt[i-1] <= j){
                    dp[i][j] = Math.max(dp[i-1][j] , dp[i-1][j-wt[i-1]]+val[i-1]);
                    
                }else{
                    dp[i][j] = dp[i-1][j];
                }
                
            }
            
        }
        return dp[n][W];
    } 
    public static void main(String []args){
        int val[] = new int[] { 60, 100, 120 };
        int wt[] = new int[] { 10, 20, 30 };
        int W = 50;
        System.out.println(Knapsack(wt,val,W));
     }
}