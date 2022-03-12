class Solution:
    def __init__(self):
        pass

    def maxValue(self, val, weights, capacity):
        if val is None or weights is None or len(val) != len(weights):
            return -1

        m = len(weights)
        n = capacity
        dp = [[0] * (n+1) for i in range(m+1)]

        for i in range(1,m+1):
            for j in range(1,n+1):
                if j >= weights[i-1]:
                    dp[i][j] = max(dp[i - 1][j], dp[i-1][j - weights[i-1]]+ val[i - 1])
                else:
                    dp[i][j] = dp[i-1][j]

        return dp[-1][-1]


obj = Solution()
value = [60,100,120]
weight = [10,20,30]
n = 60
print(obj.maxValue(value,weight,n))