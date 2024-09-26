// Time Complexity : O(W * n)
// Space Complexity : O(W)
// Did this code successfully run on Leetcode : No, but it ran on GeeksforGeeks where it was originally asked.
// Any problem you faced while coding this : No problems while I was coding the original bottom-up approach, but I made
//                                           a couple of errors when I first tried to decrease the space complexity
//                                           from O(Wn) to O(W

class Problem2
{
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n)
    {
        int max_val;
        int C1, C2;
        int[][] dp_tab = new int[2][W+1];
        for(int i = 0; i <= n; i++)
        {
            for(int j = 0; j <= W; j++)
            {
                if (i == 0 || j == 0)
                {
                    dp_tab[i%2][j] = 0;
                }
                else if(wt[i - 1] <= j)
                {
                    C1 = val[i - 1] + dp_tab[(i - 1) % 2][j-wt[i-1]];
                    C2 = dp_tab[(i - 1) % 2][j];
                    dp_tab[i % 2][j] = Math.max(C1,C2);
                }
                else
                {
                    dp_tab[i % 2][j] = dp_tab[(i - 1) % 2][j];
                }
            }
        }
        return dp_tab[n % 2][W];
    }
}