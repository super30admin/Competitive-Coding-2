// TC: O(n*capacity)
// SC: O(n*capacity)
// Solved in GFG
// Link: https://www.geeksforgeeks.org/problems/0-1-knapsack-problem0945/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=practice_card

class Problem2 {
    // Function to return max value that can be put in knapsack of capacity.
    static int knapSack(int capacity, int val[], int wt[]) {
        if (capacity == 0)
            return 0;
        if (val.length == 0 || wt.length == 0)
            return 0;

        int valN = val.length;
        int wtN = wt.length;

        int dp[][] = new int[wtN][capacity + 1];

        for (int j = wt[0]; j <= capacity; j++) {
            dp[0][j] = val[0];
        }

        for (int i = 1; i < wtN; i++) {
            for (int j = 1; j <= capacity; j++) {
                int pos1 = 0;
                if (j >= wt[i])
                    pos1 = val[i] + dp[i - 1][j - wt[i]];

                int pos2 = dp[i - 1][j];

                dp[i][j] = Math.max(pos1, pos2);
            }
        }

        return dp[valN - 1][capacity];
    }
}
