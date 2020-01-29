#knapsack 0/1 problem
#space :O(mn)
#time : O(mn)
class Knapsack:
    def solution1(self, weights, values, max_wt):
        dp = [[0 for i in range(max_wt + 1)] for i in range(len(weights) +1)]
        for i in range(1,len(weights)+1):
            for j in range(1,max_wt + 1):
                if j > weights[i-1]:
                    dp[i][j] = Max(values[i-1]+dp[i -1][j - weights[i-1]],dp[i-1][j])
                else:
                    dp[i][j] = dp[i-1][j]
        return dp[-1][-1]