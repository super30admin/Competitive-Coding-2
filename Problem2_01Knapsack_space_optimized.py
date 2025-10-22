def knapsack(weights, values, W):
    """
    Idea is to use choose and not choose of each weight to get value.
    Time ccomplexity: O(W*weights)
    Space: O(n)
    """
    n = len(values)
    dp = [0 for _ in range(W + 1)]

    for i in range(1, n + 1):
        for w in range(1, W + 1):
            if weights[i - 1] <= w:
                dp[w] = max(
                    dp[w],#not choose 
                    values[i - 1] + dp[w - weights[i - 1]] #choose
                )
            else:
                dp[w] = dp[w]
    
    return dp[W]