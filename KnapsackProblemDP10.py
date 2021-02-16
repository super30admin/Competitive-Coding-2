class Solution:
    def knapSack(self, value, weights, W, n):
        # Base Case
        if n == 0 or weights == 0:
            return 0
        return self.helper(value, weights, W, n, 0, 0)

    def helper(self, value, weights, W, n, index, maxvalue):

        #base case
        if index >= n or W == 0:
            return maxvalue

        #logic
        if weights[index] > W:
            return self.helper(value, weights, W, n, index + 1, maxvalue)

        #choose weight

        case1 = self.helper(value, weights, W - weights[index], n, index + 1,
                            maxvalue + value[index])

        #dont choose weight
        case2 = self.helper(value, weights, W, n, index + 1, maxvalue)

        return max(case1, case2)


'''Using Recursion'''


def knapSack(self, value, weights, W, n):
    dp = [[0 for i in range(W + 1)] for j in range(n + 1)]
    for i in range(n + 1):
        for j in range(W + 1):
            if i == 0 or j == 0:
                dp[i][j] = 0
            elif j < weights[i]:
                dp[i + 1][j] = dp[i][j]
            else:
                dp[i + 1][j] = max(dp[i][j], dp[j - weights[i]] + value[i]) + 1
    return dp[n][W]


'''Using DP. Time - O(n*W) Space - O(n*W)'''