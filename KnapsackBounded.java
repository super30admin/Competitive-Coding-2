// Time Complexity : O(C*N) where C is the capacity of knapsack and N number of weights
// Space Complexity : O(C*N)

// Your code here along with comments explaining your approach
// We need to find the weights that can be added to knapsack and result in maximum profit. So, using DP approach here,
// I will find out all weights that doesn't exceed knapsack capacity and find the maximum of all the profits.
//To add any weight to my knapsack, I will check the weight limits then I will compare to find maximum of from
// the profit of previous weight added to the knapsack and the current weight profit plus the profit of
// summing to target B(capacity-current weight) using the previous weight.
public class KnapsackBounded {

    public static void main(String[] args) {
        int[] wt = {10, 20, 30};
        int[] val = {60, 100, 120};
        int weight = 50;
        int result = dpKnapsack(weight, wt, val);
        System.out.println("The max profit(DP) :");
        System.out.println(result);

        System.out.println("The max profit(Recursive) :");
        System.out.println(getMaxProfit(wt, val, weight, 0, wt.length - 1));
    }

    private static int getMaxProfit(int[] wt, int[] val, int weight, int maxProfit, int index) {
        if (index < 0 || weight == 0) return maxProfit;
        if (weight < 0) return -1;

        if (weight - wt[index] < 0) {
            return getMaxProfit(wt, val, weight, maxProfit, index - 1);
        } else {
            return Math.max(getMaxProfit(wt, val, weight - wt[index], maxProfit + val[index], index - 1),
                    getMaxProfit(wt, val, weight, maxProfit, index - 1));
        }

    }

    public static int dpKnapsack(int capacity, int[] weights, int[] profit) {
        if (weights == null || profit == null) return 0;
        if (weights.length == 0 || profit.length == 0) return 0;


        int row = weights.length + 1;
        int col = capacity + 1;
        int[][] memo = new int[row][col];

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (j < weights[i - 1]) {
                    memo[i][j] = memo[i - 1][j];
                } else {
                    memo[i][j] = Math.max(memo[i - 1][j], profit[i - 1] + memo[i - 1][j - weights[i - 1]]);
                }
            }
        }

        return memo[row - 1][col - 1];
    }
}
