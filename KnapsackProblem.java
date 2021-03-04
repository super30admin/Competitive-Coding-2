
public class KnapsackProblem {

	// TC - o(2^n)
	// SC- o(n)
	private static int knapSack(int w, int[] wt, int[] val, int index) {

		// base
		if (index >= val.length || w == 0)
			return 0;

		// logic
		if (w < wt[index])
			return knapSack(w, wt, val, index + 1);
		// not choose
		int notChoose = knapSack(w, wt, val, index + 1);
		// choose
		int choose = knapSack(w - wt[index], wt, val, index + 1) + val[index];

		return Math.max(notChoose, choose);
	}

	// TC - o(nw)
	// SC -o(nw)
	private static int knapSackDP(int W, int[] wt, int[] val) {

		int n = wt.length;

		int dp[][] = new int[n + 1][W + 1];

		for (int i = 0; i <= n; i++) {
			for (int w = 0; w <= W; w++) {
				if (i == 0 || w == 0)
					dp[i][w] = 0;
				else if (wt[i - 1] <= w)
					dp[i][w] = Math.max(val[i - 1] + dp[i - 1][w - wt[i - 1]], dp[i - 1][w]);
				else
					dp[i][w] = dp[i - 1][w];
			}
		}

		return dp[n][W];
	}

	public static void main(String[] args) {

		int val[] = new int[] { 1, 2, 6 };
		int wt[] = new int[] { 2, 3, 5 };
		int W = 8;
		System.out.println(knapSack(W, wt, val, 0));
		System.out.println(knapSackDP(W, wt, val));
	}

}
