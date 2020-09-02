/*
0/1 Knapsack Problem
Approach:
Identifying DP:
1. Choice: For every item, we have 2 options - to either add it to the sack or not
2. Optimal: And we are looking to optimize the 'value' function

Decisions to make for every item:
1. If the item's weight exceeds the current capacity that we are considering, then clearly we cannot this item.
So, the maximum value that can be obtained is for the item set excluding this item, with the same capacity.
The capacity hasn't reduced here, as we haven't added item i. (Line 34)
2. If the item's weight is less than the current capacity, there are 2 options.
i. Do not choose this item, which is similar to case 1. (Line 31)
ii. Choose item. Once, item i is chosen, the capacity decreases by that weight - (w-wi),
and now the problem reduces to the item_set not containing item i, with that reduced capacity. (Line 32)
*/

public class Problem2 {
    private static int[][] dp;
    
    // Recursive solution
    // TC: O(2^n)
    // SC: Implicit stack space O(n)
    //     The stack at any point will hold the maximum number of items, eg. when we only choose the last element
    public static int recursiveKnapsack(int values[], int weights[], int w, int n) {
        if (w == 0 || n == 0) {
            return 0;
        }

        if (weights[n-1] <= w) {
            return Math.max(recursiveKnapsack(values, weights, w, n - 1),
                values[n-1] + recursiveKnapsack(values, weights, w - weights[n-1], n - 1));
        } else {
            return recursiveKnapsack(values, weights, w, n - 1);
        }
    }

    // Recursive solution with memoization
    // TC: O(n*w); n = no. of items; w - capacity
    // SC: O(n) worst case - no overlapping subproblems, so we recurse for a max of n items
    // and start popping once the leaf of the recursion tree is reached
    public static int recursiveKnapsackWithMemo(int values[], int weights[], int w, int n) {
        if (w == 0 || n == 0) {
            return 0;
        }

        if (dp[w][n] != -1) {
            return dp[w][n];
        }

        if (weights[n-1] <= w) {
            dp[w][n] = Math.max(recursiveKnapsackWithMemo(values, weights, w, n - 1),
                values[n-1] + recursiveKnapsackWithMemo(values, weights, w - weights[n-1], n - 1));
        } else {
            dp[w][n] = recursiveKnapsackWithMemo(values, weights, w, n - 1);
        }
        return dp[w][n];
    }

    // DP solution
    // TC: O(n*w); n = no. of items; w - capacity
    // SC: O(n*w); n = no. of items; w - capacity
    public static int dpKnapsack(int values[], int[] weights, int w, int n) {
        int d[][] = new int[n+1][w+1];
        
        for (int i = 1; i < d.length; i++) {
            for (int j = 1; j < d[0].length; j++) {
                if (weights[i-1] <= j) {
                    d[i][j] = Math.max(d[i-1][j], values[i-1] + d[i-1][j-weights[i-1]]);
                } else {
                    d[i][j] = d[i-1][j];
                }
            }
        }
        // printArray(d);
        return d[n][w];
    }

    public static void printArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String args[]) {
        int[] values = new int[] {6, 10, 12};
        int[] weights = new int[] {1, 2, 3};
        int w = 5;
        int n = values.length;

        System.out.println(recursiveKnapsack(values, weights, w, n));

        dp = new int[w+1][n+1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println(recursiveKnapsackWithMemo(values, weights, w, n));

        System.out.println(dpKnapsack(values, weights, w, n));
    }
}