// TC : O(m*n)
// SC : O(m*n) //since creating a separate 2-D dp array

public class Main {
    public static int knapsack(int W,int[] wt, int[] val){
        int m = wt.length; // initialise rows
        int n = W;          // initialise columns
        
        int[][] dp = new int[m+1][n+1];  // 2-D array with m+1,n+1 elements since taking into account 0th row and column.
        
        for(int i=1;i<m+1;i++){
            for(int j=1;j<n+1;j++){
                if(j<wt[i-1]){          
                    dp[i][j] = dp[i-1][j];      // copy the value present just above in the table
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], val[i-1]+dp[i-1][j-wt[i-1]]); // max b/w the two values
                }
            }
        }
        return dp[m][n];  // return the last element of the array
    }
    public static void main(String[] args) {
        int[] val = { 60, 100, 120 };
        int[] wt = { 10, 20, 30 };
        int W = 50;
        System.out.println(knapsack(W, wt, val));
    }
}