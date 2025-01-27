# tc: O(n * max_weight), sc: O(n * max_weight)
dp = [-1] * (max_weight + 1)
dp[0] = 0

for i in range(len(weights)):
    for j in range(max_weight, weights[i] - 1, -1):
        if dp[j - weights[i]] != -1:
            dp[j] = max(dp[j], dp[j - weights[i]] + values[i])
return max(dp)