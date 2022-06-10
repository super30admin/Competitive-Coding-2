'''
Time Complexity: O(m*n) where m is number of items and n is capacity of the knapsack.
Space Complexity: O(m) where m is capacity of the knapsack.
Run on leetcode : YES
'''
class Solution:
    
    #Function to return max value that can be put in knapsack of capacity W.
    def knapSack(self, W, wt, val, n):
        dp = [0] * (W + 1)
        for i in range(1,n + 1):
            for j in range(W, -1, -1):
                if not j < wt[i - 1]:
                   dp[j] = max(dp[j],val[i - 1] + dp[j - wt[i - 1]])
        return dp[W]

s = Solution()
print(s.knapSack(4,[4,5,1],[1,2,3],3))