// TC - O(N*W)
// SC - O(N*W)

// Constraints:
// 1 ≤ N ≤ 1000
// 1 ≤ W ≤ 1000
// 1 ≤ wt[i] ≤ 1000
// 1 ≤ v[i] ≤ 1000

public class KnapsackDP {
    class Solution {
        static int knapSack(int W, int wt[], int val[], int n) {
            int[][] itemToWeightMatrix = new int[n + 1][W + 1];
            for (int i = 1; i < n + 1; i++) {
                for (int j = 1; j < W + 1; j++) {
                    if (j < wt[i - 1]) {
                        itemToWeightMatrix[i][j] = itemToWeightMatrix[i - 1][j];
                    } else {
                        itemToWeightMatrix[i][j] = Math.max(itemToWeightMatrix[i - 1][j],
                                val[i - 1] + itemToWeightMatrix[i - 1][j - wt[i - 1]]);
                    }
                }
            }
            return itemToWeightMatrix[n][W];
        }
    }
}
