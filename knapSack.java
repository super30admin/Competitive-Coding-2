//time complexity: O(n*weight)
//space complexity: O(weight)

public class knapSack {
    public static int resolveKnapSack(int W, int wt[], int val[], int n) {
        int[] dp = new int[W + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = W; j >= 0; j--) {
                if (wt[i - 1] <= j) {
                    dp[j] = Math.max(dp[j], dp[j - wt[i - 1]] + val[i - 1]);
                }
            }
        }
        return dp[W];
    }

    public static void main(String[] args) {
        int val[] = { 60, 50, 100 };
        int wt[] = { 10, 40, 30 };
        int W = 50;
        int n = val.length;
        System.out.print(resolveKnapSack(W, wt, val, n));
    }

}