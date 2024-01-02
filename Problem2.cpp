/*
 * Title: 0-1 Knapsack
 * Time Complexity : O(n*W)
 * Space Complexity : O(n*W)
 * Did this code successfully run on Leetcode : Yes
 * Any problem you faced while coding this : No
*/

#include <vector>

class Solution
{
    private:
        int helper(int idx, int wt[], int profit[], int weightTillNow, int n, std::vector<std::vector<int>>& memo) {
            // ! base case
            if (idx >= n || weightTillNow <= 0)
                return 0;
            // return if already explored the path
            if (memo[idx][weightTillNow] != -1)
                return memo[idx][weightTillNow];

            // ! logic
            // choose case
            int choose = 0;
            if (wt[idx] <= weightTillNow) {
                choose = profit[idx] + helper(idx + 1, wt, profit, weightTillNow - wt[idx], n, memo);
            }

            // not choose
            int not_choose = helper(idx + 1, wt, profit, weightTillNow, n, memo);

            // storage
            memo[idx][weightTillNow] = std::max(choose, not_choose);

            return memo[idx][weightTillNow];
        }
    public:
    //Function to return max value that can be put in knapsack of capacity W.
    int knapSack(int W, int wt[], int val[], int n)
    {
        std::vector<std::vector<int>> memo(n, std::vector<int> (W + 1, -1));
        return helper(0, wt, val, W, n, memo);
    }
};