# Time Complexity : O(Capacity * W) where W is size of weight elements
# Space Complexity : O(Capacity * W)


value = [60, 100, 120]
weight = [10, 20, 30]
capacity = 50

dp = [[0] * (capacity + 1) for _ in range(len(weight))]
for i in range(len(dp)):
  for j in range(weight[i], len(dp[0])):
    if i == 0:
        dp[i][j] = value[i]
    else:
        dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i])
print(dp[-1][-1])