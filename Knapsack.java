/* 0-1 Knapsack Problem
* TC O(N*W) SC O(N*W)
public class Knapsack {

	// Driver code
	public static void main(String args[]) {
		int val[] = new int[] { 60, 100, 120 };
		int wt[] = new int[] { 10, 20, 30 };
		int W = 50;
		int n = val.length;
		System.out.println(knapSack(W, wt, val, n));
	}

	private static int knapSack(int W, int wt[], int val[], int n) {
		int i, w;
		int K[][] = new int[n + 1][W + 1];

		// Build table K[][] in bottom up manner
		for (i = 0; i <= n; i++) {
			for (w = 0; w <= W; w++) {
				if (i == 0 || w == 0)
					K[i][w] = 0;
				else if (w - wt[i - 1] >= 0) {
					K[i][w] = Math.max(val[i - 1] + K[i - 1][w - wt[i - 1]], K[i - 1][w]);
				} else {
					K[i][w] = K[i - 1][w];
				}
			}
		}
		return K[n][W];
	}
}

