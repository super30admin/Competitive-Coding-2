public class Problem2 {
    private static int knapsack(int[] value, int[] weights, int capacity) {
        int[][] dp = new int[value.length + 1][capacity + 1];
        // case: when capacity j is 0
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }
        // case: when item i is null, has no weight provides no worth
        for (int j = 0; j < dp[0].length; j++) {
            dp[0][j] = 0;
        }
        // standard "dp" way
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] = dp[i - 1][j]; // start off by not including item in knapsack
                if (j >= weights[i - 1]) { // feasibility check
                    // include if, it yields optimal worth
                    dp[i][j] = Math.max(dp[i][j], value[i - 1] + dp[i - 1][j - weights[i - 1]]);
                    // dp[i][j] this is if item is not there in knapsack
                    // value[i - 1] + dp[i - 1][j - weights[i - 1]] --> this is when item is there in the knapsack
                    // Max of both values would give result
                    //
                    // value[i - 1] is the profit of that item that is chosen
                    // dp[i - 1][j - weights[i - 1]] --> this means it is checkig the optimised value of the previous element with the remaining capacity after subtracting the item weight from `j` 
                    // j - weights[i - 1] --> this here j is the capacity and weights[i-1] is the current chosen item weight - if weight is left after choosing it - we will add it with current item profit and then select max
                }
            }
        }
        return dp[value.length][capacity];
    }
    
    public static void main(String[] args){
        int C = 6;
        int[] wt = {1,2,3};
        int[] p = {10,15,40};
        int n = 3;
        int profit = knapSack(p, wt, C);
        System.out.println(profit);
    }


}
