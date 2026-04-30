class Solution {

    public static int findMax(int[] weights, int[] profit, int totalCapacity) {
        int n = totalCapacity;
        int m = weights.length;
        int[] dp = new int[n + 1];

        for (int i = 0; i < m; i++) {
            for (int j = n; j >= weights[i]; j--) {
                dp[j] = Math.max(dp[j], profit[i] + dp[j - weights[i]]);
            }
        }

        return dp[n];
    }

    public static void main(String args[]) {
        int[] items = {10, 20, 30, 40};
        int[] profit = {130, 110, 170, 190};
        int capacity = 50;

        System.out.println(findMax(items, profit, capacity));
    }
}