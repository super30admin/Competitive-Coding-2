// Recursion - TC: O(2^m+n), SC: O(m+n)
public class KnapSackRecursion {
    public static void main(String[] args) {
        int[] profit = {60, 100, 120};
        int[] weight = {10, 20, 30};
        int capacity = 50;
        System.out.println(helper(profit, weight, capacity, 0, 0));
    }

    private static int helper(int[] profit, int[] weight, int capacity, int i, int totalProfit) {
        //base case
        if (i >= weight.length) {
            return totalProfit;
        }

        //No Choose
        int case0 = helper(profit, weight, capacity, i + 1, totalProfit);

        //Choose
        int case1 = 0;
        if (weight[i] <= capacity) {
            case1 = helper(profit, weight, capacity - weight[i], i + 1, totalProfit + profit[i]);
        }

        return Math.max(case0, case1);
    }

}