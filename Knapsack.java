public class Knapsack {

    static int[] dp;

    public static int solution(int n, int W, int[] profit, int[] weight) {
        dp = new int[weight.length];
        return helper(n, W, profit, weight, 0, weight[0]);
    }

    private static int helper(int n, int W, int[] profit, int[] weight, int idx, int totw) {
        if (totw > W)
            return 0;

        else if (idx == n)
            return 0;

        if (dp[idx] > 0)
            return dp[idx];

        int case1 = helper(n, W, profit, weight, idx + 1, totw);
        int case2 = profit[idx] + helper(n, W, profit, weight, idx + 1, totw + weight[idx]);

        dp[idx] = Math.max(case1, case2);
        return dp[idx];
    }

    public static void main(String[] args) {
        int N = 3;
        int W = 4;
        int[] profit = { 1, 2, 3 };
        int[] weight = { 4, 5, 1 };
        int x = solution(N, W, profit, weight);
        System.out.println(x);
    }

}
