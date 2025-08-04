// KnapSack Problem

TC: O(m*n)
SC: O(m*n)
public class Main {
    public static void main(String args[]){
        
        //Start with an Example
        int[] profit = {60, 100,120};
        int[] weight = {10, 20, 30};
        int capacity =50;
        int m = weight.length;
        int n = capacity;
        
        //Using DP initialize an Array
        int[][] dp = new int[m+1][n+1];
        
        // Make the 1st elements as Constants
        for(int i=0;i<=n;i++){
            dp[0][i]=0;
        }
        // 
        for(int i = 1;i <= m; i++){
            for( int j = 1; j <=n; j++) {
                if (j< weight[i-1]){  // base case
                    dp[i][j] = dp[i-1][j];
                }
                else {  // Find the Max of an element Previous one or dp[take(profit)] + Profit of left element
                    dp[i][j] = Math.max(dp[i-1][j], profit[i-1]+dp[i-1][j-weight[i-1]]);
                }
            }
        }
        System.out.println(dp[m][n]);
    }
}