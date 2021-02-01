// Time Complexity: O(MN) | M = weights.length, N = W
// Space Complexity: O(MN)
public class Solution {
    public static int Knapsack(int[] val, int[] weights, int W){
        int[][] dp = new int[weights.length+1][W+1];
        for(int i=1;i<=weights.length;i++){
            for(int j=0;j<=W;j++){
                int weight = weights[i-1];
                int valOfWeight = val[i-1];
                if(j-weight>=0)
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-weight]+valOfWeight);
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        return dp[weights.length][W];
    }
    public static void main(String[] args){
        int[] val = {60,100,120};
        int[] weight = {1,2,3};
        int w = 5;
        System.out.println(Knapsack(val,weight,w));
    }
}