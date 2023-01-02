// 0/1 knapsack
// Time Complexity : o(mn)
// Space Complexity : o(mn)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
/*
 *  At any position, can pick or not pick the element
 *  Create a 2-D dp array.
 *  maximum value that could be obtained by choosing elements till i for a knapsack capacity of j  =   Maximum of
 *       1. value that could be obtained by not choosing the element ( dp[i-1][j])
 *       2. value of element + ( dp[i-1][j - weight of the element])
 * */

class Problem1 {

    public static int helper(int[] weights, int[] values, int cap){
        int n = values.length +1;
        int m = cap +1;
        int[][] dp = new int[n][m];
        for(int i = 1; i < n ; i++){
            for(int j = 0; j < m ; j++){
                if(weights[i-1] > j ){
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = Math.max(
                            dp[i-1][j - weights[i-1]]
                                    + values[i-1] , dp[i-1][j]);
                }
            }
        }

        return dp[n-1][m-1];


    }
    public static void main(String[] args) {
        int    values[] = new int []{1,2,3};
        int  weights[] = new int[]{2,5,1};
        int cap = 4;

        int res = helper(weights, values, cap);
        System.out.println(res);

    }
}