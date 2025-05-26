// TC - O(n^2)
// SC - O(n)
// Approach - Consider all subsets of items and calculate total weight and value of all 
// subsets. Consider only subsets whose total weight is less than W. 

public class Knapsack_Recursive {

  static int helper(int W, int[] val, int[] wt, int n) {

    // base case
    if (n == 0 || W == 0)
      return 0;

    int pick = 0;

    // pick , don't pick
    if (wt[n - 1] <= W)
      pick = val[n - 1] + helper(W - wt[n - 1], val, wt, n - 1);
    int nopick = helper(W, val, wt, n - 1);

    return Math.max(pick, nopick);
  }

  static int knapsack(int W, int[] val, int[] wt) {
    int n = val.length;
    return helper(W, val, wt, n);
  }

  public static void main(String[] args) {
    int W = 50;
    int[] val = new int[] { 60, 100, 120 };
    int[] wt = new int[] { 10, 20, 30 };

    System.out.println(knapsack(W, val, wt));
  }
}
