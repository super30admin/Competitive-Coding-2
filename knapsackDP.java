public class Main {
    public static int maxSum(int[] weights, int[] profits, int capacity) {
        //null case will handle
        int n = weights.length;
        //my rows are weights and columns are the capacity
        //if the column is less than the weight then just takes the values from the row above
        //pattern is it takes Max of above row same column value and above row prev value (go back current weight times)
        //O(n*2)
        int[][] dp = new int[n + 1][capacity + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= capacity; j++) {
                if (weights[i - 1] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], profits[i - 1] + dp[i - 1][j - weights[i - 1]]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][capacity];
    }
    public static void main(String[] args) {
        System.out.println("Hello World!");
        int[] weights = {10, 20, 30};
        int[] profits = {60,90,120};
        int capacity = 50;
        System.out.println(maxSum(weights, profits, capacity));
    }
}