#I simplified the code by using a 1D array dp instead of a 2D table. The array dp keeps track of the maximum profit for each capacity up to W. For each item, I iterate through the capacities in reverse order to ensure that each item is only considered once. By updating the dp array in this manner, I efficiently compute the maximum profit that can be achieved with the given items and bag capacity. The final result is stored in dp[W], which represents the maximum profit for the full capacity of the bag. This approach reduces both the space and time complexity of the solution.

def knapsack(N, W, profit, weight):
    dp = [0] * (W + 1)
    
    for i in range(N):
        for w in range(W, weight[i] - 1, -1):
            dp[w] = max(dp[w], dp[w - weight[i]] + profit[i])
    
    return dp[W]

# Example usage
N = 3
W = 4
profit = [1, 2, 3]
weight = [4, 5, 1]

result = knapsack(N, W, profit, weight)
print(f"Maximum profit: {result}")