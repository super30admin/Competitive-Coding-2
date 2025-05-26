// Time Complexity : O(n * c) where n is the number of items and c is the capacity of the knapsack
// Space Complexity : O(n * c) where n is the number of items and c is the capacity of the knapsack
//Approach : Dynamic Programming with Memoization

public class Problem1 {

    public static int getMaxProfit(int c, int[] w, int[] p) {
        if (w == null || p == null)
            return -1;
        if (w.length != p.length)
            return -1;

        int[][] memo = new int[w.length + 1][c + 1];
        for (int i = 0; i < w.length; i++) {
            for (int j = 0; j < c; j++) {
                memo[i][j] = -1;
            }
        }

        // helper
        return helper(c, w, p, 0, 0, 0, memo);
    }

    public static int helper(int capacity, int[] w, int[] p, int cw, int cp, int idx, int[][] memo) {
        // base
        if (idx >= w.length || cw > capacity)
            return 0;

        if (memo[idx][cw] != -1)
            return memo[idx][cw];

        // logic
        // not choose
        int case1 = helper(capacity, w, p, cw, cp, idx + 1, memo);

        // choose
        int case2 = -1;
        if (cw + w[idx] <= capacity) { // 10
            case2 = p[idx] + helper(capacity, w, p, cw + w[idx], cp + p[idx], idx + 1, memo); // 60 +
        }

        memo[idx][cw] = Math.max(case1, case2);

        return Math.max(case1, case2);
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
        int c = 50;
        int[] w = { 10, 20, 30 };
        int[] p = { 60, 100, 120 };

        System.out.println("max prof " + getMaxProfit(c, w, p));
    }
}
