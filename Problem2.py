# Time Complexity : O(n*m)
# Space Complexity : O(n*m)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


class Solution:
  def Bag(self, weight: List[int], value: List[int]) -> int:

    dp = [[0 for _ in range(50+1)] for _ in range(len(weight)+1)]
    for i in range(1, len(weight)+1):
        for j in range(1, 50+1):
            if j >= weight[i-1]:
                dp[i][j] = max(dp[i-1][j], value[i-1] + dp[i-1][j - weight[i-1]])
            else:
                dp[i][j] = dp[i-1][j]