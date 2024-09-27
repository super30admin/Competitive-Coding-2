# TC: O(N X C) where N is the length of the weights array and C is the capacity of the knapsack.
# SC: O(N X C) DP matrix to store the mappings of max profit at each selection.

class Solution:

    # Function to return max value that can be put in knapsack of capacity W.
    def knapSack(self, W, wt, val, n):
        dp = [[0 for i in range(W + 1)] for j in range(len(wt) + 1)]

        for i in range(W + 1):
            dp[0][i] = 0

        for i in range(1, len(wt) + 1):
            for j in range(1,W + 1):
                dp[i][j] = max(dp[i-1][j], dp[i-1][j - wt[i - 1]] + val[i - 1])

        return dp[-1][-1]



if __name__ == '__main__':
    n = 3
    W = 50
    W1 = 8
    wt = [10, 20, 30]
    wt1 = [2,3,5]
    val1 = [1,2,6]
    val = [60, 100, 120]
    obj = Solution()
    print(obj.knapSack(W, wt, val, n))
    print(obj.knapSack(W1, wt1, val1, n))
