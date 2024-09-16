// Time: O(mn) where m*n is capacity * weights.length
// Space: O(mn)

/*
 * here we create a martix with the weights as y axis and capacity as the x axis.
 * the values we get are the max values we can form using the weight and given capacity.
 */

public class Knapsack {
    public static int knapsack(int[] values, int[] weights, int capacity){
        if(weights == null || weights.length == 0) return 0;
        if(values == null || values.length == 0) return 0;
        int n = weights.length;
        int [][] dp = new int[n+1][capacity+1];
        for(int i = 0; i < capacity; i++) dp[0][i] = 0;
        for(int i = 1; i <= n; i++){
            for(int j = 0; j <= capacity; j++){
                if(weights[i-1] <= j){
                    dp[i][j] = Math.max(values[i-1]+dp[i-1][j-weights[i-1]], dp[i-1][j]);
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][capacity];
    }
    public static void main(String[] args) {
        int[] values = {60,100,120};
        int[] weights = {10,20,30};
        int capacity = 50;
        System.out.println(knapsack(values, weights, capacity));
    }
}