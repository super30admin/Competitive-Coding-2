package knapsack;

// Time Complexity :O(2^n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :No
// Any problem you faced while coding this :Time limit exceed

public class Exhaustive {

    public static void main(String[] args) {

        int[] profit = {60, 100, 120};
        int[] weight = {10, 20, 30};
        int capacity = 50;

        System.out.println(helper(profit, weight, capacity, 0, 0));
    }

    private static int helper(int[] profit, int[] weight, int capacity, int i, int totalProfit)
    {
//        base case
        if(i >= weight.length) {
            return totalProfit;
        }

//        logic
        int case0 = helper(profit, weight, capacity, i + 1, totalProfit);

        int case1 = 0;

        if(weight[i] <= capacity) {
            case1 = helper(profit, weight, capacity - weight[i], i + 1, totalProfit + profit[i]);
        }

        return Math.max(case0, case1);
    }
}
