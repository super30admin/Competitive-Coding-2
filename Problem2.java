//T.C-O(nxw)
//S.C-O(nxw)
//passed all the test cases
// the approach is to take or not take any item into the knapsack bag.
class Solution {
    // Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n) {
        // your code here
        int ks[][] = new int[n + 1][W + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < W + 1; j++) {
                if (i == 0 || j == 0) {
                    ks[i][j] = 0;
                } else if (wt[i - 1] <= j) {
                    ks[i][j] = Math.max(ks[i - 1][j], val[i - 1] + ks[i - 1][j - wt[i - 1]]);
                } else {
                    ks[i][j] = ks[i - 1][j];
                }
            }
        }
        return ks[n][W];

    }
}