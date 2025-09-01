import java.util.Arrays;
//Time Complexity: O(n * m), n -> no of weights, m -> sack capacity
//Space Complexity: O(n * m)
//Did this code successfully run on Leetcode : Yes
//Approach: For every weight, we have an option to choose (if weight less than sack capacity), or to not choose
//We will choose the max from the choose or the not choose option, there will be overlapping subproblems, which makes this a candidate for dynamic programming (for better performance)
public class Knapsack {

    private int[][] memo;

    /**
     *
     * @param W   the max capacity of the sack
     * @param val the val corresponding to each weight
     * @param wt  the weight array
     * @return    the max value the sack can offer for the weights chosen
     */
    public int knapsack(int W, int[] val, int[] wt) {
        this.memo = new int[wt.length][W + 1];
        for (int i = 0; i < wt.length; i++) Arrays.fill(this.memo[i], -1);

        return helper(wt, val, 0, W);
    }

    private int helper(int[] wt, int[] val, int index, int W) {
        if (wt.length == index) return 0;
        if (W <= 0) return 0;
        if (this.memo[index][W] != -1) return this.memo[index][W];

        int nChoose = helper(wt, val, index + 1, W);
        int choose = 0;
        if (wt[index] <= W) {
            choose = val[index] + helper(wt, val, index + 1, W - wt[index]);
        }

        this.memo[index][W] = Math.max(choose, nChoose);
        return this.memo[index][W];
    }

    public static void main(String[] args) {
        final Knapsack knapsack = new Knapsack();
        System.out.println(knapsack.knapsack(5, new int[] {6, 10, 12}, new int[] {1, 2, 3}));     //return 22
        System.out.println(knapsack.knapsack(4, new int[] {1, 2, 3, 4}, new int[] {4, 5, 1, 2})); //return 7
    }
}
