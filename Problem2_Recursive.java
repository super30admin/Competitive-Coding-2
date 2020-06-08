// Recusrsive Approch
// Time complexity - O(2^n)
// Sapce complexity - Don't know

// Implemented using recursion.


public class Knapsack {

	static int knapSack(int W, int wt[], int val[], int n) {
		int ans = 0;
		int index = 0;
		int remainingCap = 0;
		return helper(W, wt, val, ans, index, remainingCap);

	}

	private static int helper(int w, int[] wt, int[] val, int ans, int index, int cap) {
		if (cap > w) {
			return 0;
		}
		if (index >= val.length) {
			return ans;
		}
		// if choose weight
		int case1 = helper(w, wt, val, ans + val[index], index + 1, cap + wt[index]);

		// if not choose weight
		int case2  = helper(w, wt, val, ans, index + 1, cap);
		return Math.max(case1, case2);
	}

	public static void main(String args[]) {
		int wt[] = new int[] { 10, 20, 30 };
		int val[] = new int[] { 60,100,120};
		int W = 50;
		int n = val.length;
		System.out.println(knapSack(W, wt, val, n));
	}
}
