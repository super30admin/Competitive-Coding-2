// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class KnapSack {
    private static int knapSack (int W, int[] wt, int[] val, int n){
        int[][] dp = new int[n+1][W+1];

        for(int i = 0; i < dp.length; i++){ // values
            for(int j = 0; j < dp[0].length ; j++){ //wts

                if(i==0 || j == 0){     // filling first row and column with 0s
                    dp[i][j] = 0;
                } else if (j >= wt[i-1]){ // if the curr_amount is greater than or equals to weight amount at particular index
                    // Take maximum of [previous row and same column] and [value for corresponding weight + dp[prev column]
                    // [curr column index - weight amount at this index]]
                    dp[i][j] = Math.max(val[i-1] + dp[i-1][j-wt[i-1]], dp[i-1][j]);
                } else {
                    // If none of above , copy values from prev column
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }

        return dp[dp.length - 1][dp[0].length - 1];
    }
    public static void main (String[] args) {
        int val[] = new int[]{6, 10, 12};
        int wt[] = new int[]{1, 2, 3};
        int  W = 5;
        int n = val.length;
        System.out.println(knapSack(W, wt, val, n));
    }
}
