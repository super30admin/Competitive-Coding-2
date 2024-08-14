//Time Complexity: O(w*n) // w is the total weight and n is the number of elements
//Space Complexity: O(w*n) //w is the total weight and n is the number of elements
public class KnapSack {

    static int knapSack(int W, int wt[], int val[], int n)
    {
        int dp[][] = new int[n+1][W+1];
        for(int i=0;i<=W;i++){
            dp[0][i] = 0;
        }
        for(int i=1;i<=wt.length;i++){
            for(int j = 0;j<=W;j++){
                if(wt[i-1]>j){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], val[i-1] + dp[i-1][j-wt[i-1]]);
                }
            }
        }
        return dp[n][W];

    }
}
