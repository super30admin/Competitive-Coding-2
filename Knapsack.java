import java.util.Arrays;

class Knapsack {
 //Time Complexity: Exponential, going over each subset. 2^N (N is the number of items in the bag)
 //Space Complexity: Recusrin (depth * width of the tree)

public int knapSack(int W, int wt[], int val[], int n) {
        // Base Case
        if (n == 0 || W == 0) {
                return 0;
        }

        //choose the item
        //you can only choose an item if the weight is less than or equal to given max/allowed Weight.
        int case1 = 0, case2 = 0;

        if (wt[n-1] <= W) {
                case1 = val[n - 1] + knapSack(W - wt[n - 1], wt, val, n - 1);
        }
        //no choose
        case2 = knapSack(W, wt, val, n-1);

        return Math.max(case1, case2);
}


/* Solution 2 using memoization */
   //Time Complexity: O(N)...going of each item
   //Space Complexity: O(N * Weight) as we are taking a 2d array.
       int[][] dp;
        public int knapSack1(int W, int wt[], int val[], int n) {
                // Base Case
                if (n == 0 || W == 0) {
                        return 0;
                }

                if (dp[n-1][W] != -1) {
                    return dp[n-1][W];
                }
                //choose the item
                //you can only choose an item if the weight is less than or equal to given max/allowed Weight.
                int case1 = 0, case2 = 0;

                if (wt[n-1] <= W) {
                        case1 = val[n - 1] + knapSack1(W - wt[n - 1], wt, val, n - 1);
                }
                //no choose
                case2 = knapSack1(W, wt, val, n-1);

                dp[n-1][W] = Math.max(case1, case2);
                return dp[n-1][W];
        }

// Driver code
public static void main(String[] args) {
        Knapsack ks = new Knapsack();
        int val[] = new int[] { 60, 100, 120 };
        int wt[] = new int[] { 10, 20, 30 };
        int W = 50;
        int n = val.length;
        ks.dp = new int[n][W + 1];
        for (int i = 0; i < n; i++) {
                Arrays.fill(ks.dp[i], -1);
        }
        System.out.println(ks.knapSack(W, wt, val, n));
        System.out.println(ks.knapSack1(W, wt, val, n));
}
}