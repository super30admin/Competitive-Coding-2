'''
This function solves the 0/1 knapsack problem using a dynamic programming approach.
It utilizes a one-dimensional DP array where each index represents the maximum value that can be achieved with that exact weight capacity.
The function iterates over all items, updating the DP array in reverse to ensure that each item is only considered once.

Time Complexity: O(nW) -> n is the number of items
                        W is the maximum weight capacity of the knapsack.
Space Complexity: O(W) -> W is again the maximum weight capacity of the knapsack.
'''
def knapsack(W, val, wt):
    
    dp = [0] * (W + 1)

    for i in range(1, len(wt) + 1):
        for j in range(W, wt[i - 1] - 1, -1):
            dp[j] = max(dp[j], dp[j - wt[i - 1]] + val[i - 1])
    
    return dp[W]

print(knapsack(4, [1, 2, 3], [4, 5, 1]))