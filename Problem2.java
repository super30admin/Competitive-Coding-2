// Time Complexity:  O(n*W)
// Space Comlpexity: O(n*W)

class Knapsack {

    static int knapSack(int[] wt, int[] val, int W, int n)
    {
        int[][] K = new int[n + 1][W + 1];

        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= W; w++) {
                if (i == 0 || w == 0)
                    K[i][w] = 0;
                else if (w < wt[i-1])
                    K[i][w] = K[i - 1][w];
                else
                    K[i][w] = Math.max(
                        K[i - 1][w],
                        val[i - 1] + K[i - 1][w - wt[i - 1]]
                    );
            }
        }

        return K[n][W];
    }

    public static void main(String[] args)
    {
        int[] profit = new int[] { 60, 100, 120 };
        int[] weight = new int[] { 10, 20, 30 };
        int W = 50;
        int n = profit.length;
        System.out.println(knapSack(weight, profit, W, n));
    }
}
