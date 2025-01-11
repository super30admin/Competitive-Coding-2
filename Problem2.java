public class Problem2 {
    // 0/1 Knapsack Problem
    // Note: I have written both the recursive and the dp solution.
    public static int knapsack(int[] weights, int[] values, int capacity) {

        int dp[][] = new int [weights.length+1][capacity+1];


        for (int i =1;i < dp.length;i++){
            for (int j = 1; j < dp[0].length; j++) {
                if (weights[i-1] > j){
                    dp[i][j] = dp [i-1][j];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][Math.max(j-weights[i-1],0)]+values[i-1]);
                }
            }
        }

        return dp[weights.length][capacity];
    }


    public static int knapsackRecursive(int[] weights, int[] values, int capacity) {
    if (weights.length == 0){
        return 0;
    }
        return dfs (weights, values, capacity,weights.length-1,capacity, 0);

    }

    private static int dfs (int[] weights, int[] values, int capacity, int index, int curWeight, int curProfit){
        if (curWeight < 0){
            return 0;
        }
        if (index< 0){
            return curProfit;
        }

        // case 1: did not consider index-1
        int case1 = dfs(weights, values, capacity, index-1, curWeight, curProfit);
        //case : considered index-1
        int case2 = dfs(weights, values, capacity, index-1, curWeight-weights[index],curProfit + values[index]);
        return Math.max(case1, case2);

    }
    public static void main(String[] args) {
        int[] weights = {1,2,3};
        int[] values = {10,15,40};
        int capacity = 6;
        System.out.println(knapsack(weights, values, capacity));// expected output: 65
    }
}
