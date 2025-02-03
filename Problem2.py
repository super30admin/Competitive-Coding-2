# Problem 2: Knapsack

# Time Complexity: O(n*capacity)
# Space Complexity: O(n*capacity)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No

def maximizeProfit(weights, values, capacity):
    n = len(weights)
    
    dp = [[0]*(capacity+1) for _ in range(n+1)]
    
    for i in range(1, n+1):
        for j in range(1, capacity+1):
            if weights[i-1] <= j:
                # either include or exclude
                include = values[i-1] + dp[i-1][j - weights[i-1]]
                exclude = dp[i-1][j]
                dp[i][j] = max(include, exclude)
            else:
                dp[i][j] = dp[i-1][j]
                
    return dp[n][capacity]


weights1 = [2, 3, 4, 5]
values1 = [3, 4, 5, 6]
capacity1 = 5
print(maximizeProfit(weights1, values1, capacity1))  # Expected: 7

weights2 = [1, 2, 3, 8]
values2 = [10, 15, 40, 50]
capacity2 = 6
print(maximizeProfit(weights2, values2, capacity2))  # Expected: 65

weights3 = [5, 10, 20]
values3 = [10, 20, 30]
capacity3 = 4
print(maximizeProfit(weights3, values3, capacity3))  # Expected: 0

weights4 = [1, 3, 4]
values4 = [15, 50, 60]
capacity4 = 3
print(maximizeProfit(weights4, values4, capacity4))  # Expected: 50

weights5 = [1, 2, 3]
values5 = [10, 20, 30]
capacity5 = 6
print(maximizeProfit(weights5, values5, capacity5))  # Expected: 60

weights6 = [3, 4, 6, 5]
values6 = [2, 3, 1, 4]
capacity6 = 8
print(maximizeProfit(weights6, values6, capacity6))  # Expected: 6
    