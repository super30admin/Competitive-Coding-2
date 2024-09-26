// Time Complexity :O(mn)
// Space Complexity :O(mn)
// Did this code successfully run on Leetcode : not on leetcode, but value matches expected value from geeksongeeks
// Any problem you faced while coding this : getting started


// Your code here along with comments explaining your approach

public class ZeroOneKnapSack {

    public static int knapsack01(int[] value, int[] weight, int W){
        int row = value.length+1;
        int col = W+1;

        //creating dp array
        int[][]dp = new int[row][col];

        //loop and add
        for(int i = 1; i <= row-1; i++){
            for(int j = 0; j<=col-1; j++){
                if(weight[i-1] <= j){
                    //optimize to get max value from previous row or computing value
                    dp[i][j] = Math.max(dp[i-1][j], (dp[i-1][j - weight[i-1]]) + value[i-1]);
                } else {
                    //copy value from prevous row
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        //get value for last element
        return dp[row-1][col-1];
    }


    public static void main(String[] args) {
        int[] value = {60, 100, 120};
        int[] weight = {10, 20, 30};
        int W = 50;

        System.out.println(knapsack01(value, weight, W));
    }

}
