// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : yes
public class Knapsack {
    public static int maxVal(int[] val, int[] weight, int capacity){
        if(val.length == 0 ||val == null)return -1;
                    if(weight.length == 0 ||weight == null)return -1;
        if(capacity <= 0)return -1;

        int[][] dp = new int[val.length + 1][capacity + 1];
        for(int i = 0; i<dp.length; i++){
            dp[i][0] = 0;
        }
        for(int j = 0; j<dp[0].length; j++){
            dp[0][j] = 0;
        }
        for(int i=1; i<dp.length; i++){
            for(int j=1; j<dp[0].length; j++){
                if(j < weight[i-1]){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weight[i-1]] + val[i-1]);
                }
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }
    
    public static void main(String[] args) {
        int[] val = {6,10,12};
        int[] weight = {1,2,3};
        int capacity = 5;
        int maxVal = maxVal(val, weight, capacity);
        System.out.println("Hello World!" + maxVal);
    }
}