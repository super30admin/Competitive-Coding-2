time complexity: O(n*W)
space complexity: O(n*W)

public static int knapsack(int[] v, int[] w, int W) //v = profit values, w = weights, W = knapsack capacity
    {
        // T[i][j] stores the maximum value of knapsack having weight less than equal to `j` with only first `i` items considered.
        int[][] T = new int[v.length + 1][W + 1];
 
        //doing for ith item
        for (int i = 1; i <= v.length; i++)
        {
            // considering all weights from 0 to maximum capacity `W`
            for (int j = 0; j <= W; j++)
            {
                // we aren't including the ith element if j-w[i-1] is negative
                if (w[i-1] > j) {
                    T[i][j] = T[i-1][j];
                }
                else {
                    // finding the maximum value by excluding or including the ith item
                    T[i][j] = Integer.max(T[i-1][j], T[i-1][j-w[i-1]] + v[i-1]);
                }
            }
        }
 
        // returning maximum value
        return T[v.length][W];
    }