// TC - O(2^N)
// SC - O(N)

// Constraints:
// 1 ≤ N ≤ 1000
// 1 ≤ W ≤ 1000
// 1 ≤ wt[i] ≤ 1000
// 1 ≤ v[i] ≤ 1000

public class KnapsackRecursion {
    class Solution {
        static int knapSack(int W, int wt[], int val[], int n) {
            return helper(W, wt, val, 0, 0);
        }

        static int helper(int W, int wt[], int val[], int index, int totalProfit) {
            if (W == 0 || index >= wt.length) {
                return totalProfit;
            }
            if (W < 0) {
                return Integer.MIN_VALUE;
            }

            int currItemChosen = helper(W - wt[index], wt, val, index + 1, totalProfit + val[index]);
            int currItemNotChosen = helper(W, wt, val, index + 1, totalProfit);

            return Math.max(currItemChosen, currItemNotChosen);
        }
    }
}
