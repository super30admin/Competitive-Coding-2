public class Solution {
    public static void main(String[] args) {
        int[] profits = {60, 100, 120};
        int[] weights = {10, 20, 30};
        int capacity = 50;
        MaxProfit obj = new MaxProfit();
        int maxProfit = obj.getMaxProfit(profits, weights, 0, capacity, 0 );
        System.out.println("Max profit = " + maxProfit);

    }

}

class MaxProfit{
    public int getMaxProfit(int[] profits, int[] weights, int index, int capacity, int amount) {
        // Recursion
        //TC: O(2^N) ->  N - profits.length
        //SC: O(1)
        //Did it run successfully on Leetcode? : Yes

//        Base case
//        if (capacity <= 0 || index >= profits.length)
//            return amount;
//
//        // logic
//        // choose
//        int case1 = 0;
//        if (capacity >= weights[index]) {
//            case1 = getMaxProfit(profits, weights, index + 1, capacity - weights[index], amount + profits[index]);
//        }
//        // dont choose
//        int case2 = getMaxProfit(profits, weights, index + 1, capacity, amount);
//
//        return Math.max(case1, case2);
//    }

        // DP
        //TC: O(M*N) -> M - profits+1, N - capacity + 1
        //SC: O(M*N) -> M - profits+1, N - capacity + 1
        //Did it run successfully on Leetcode? : Yes

        int[][] dp = new int[profits.length + 1][capacity + 1];
        for ( int i = 1; i < dp.length; i++)
        {
            for (int j = 1; j < dp[0].length; j++)
            {
                 if ( j < weights[i-1])
                {
                    dp[i][j] = dp[i-1][j];
                }
                else
                {
                    dp[i][j] = Math.max(dp[i-1][j], profits[i-1] + dp[i-1][j-weights[i-1]]);
                }
            }
        }
        return dp[dp.length-1][dp[0].length-1];


    }
}

