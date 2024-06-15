"""
Problem:
0/1 Knapsack Problem

Input: N = 3, W = 4, profit[] = {1, 2, 3}, weight[] = {4, 5, 1}
Output: 3
Explanation: There are two items which have weight less than or equal to 4. If we select the item with weight 4, the possible profit is 1. And if we select the item with weight 1, the possible profit is 3. So the maximum possible profit is 3. Note that we cannot put both the items with weight 4 and 1 together as the capacity of the bag is 4.

Input: N = 3, W = 3, profit[] = {1, 2, 3}, weight[] = {4, 5, 6}
Output: 0

Mock Interview Solutions
https://youtu.be/4JDvBw6jJio

Time Complexity : O(n*w) where n is no of weights, w is capacity
Space Complexity : O(n*w) 
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Your code here along with comments explaining your approach:
Trick is to go exhaustive since there are repeatitive subproblems.
Variables that are playing role are n, capacity so we need result for each weight what's the max profit we can form it
so we're creating a 2d array inbetween len(weights)+1 and capacity+1 and start iterating by keeping default values as 0.
Recurrence relation is formed when a weight is included calculate its current profit i.e., profit[i-1] and add it's remanining weight
i.e.m dp[current_weight - wt[i-1]] & check which is max inbetween current & previous result. Also make sure this is calculated only
when current weight is less than or equal to current loop weight.
"""

# top down
def knapsack(n, profits, weights, capacity):
    if n == 0 or capacity == 0 or len(profits) == 0 or len(weights) == 0:
        return 0
    
    if weights[n-1] > capacity: # don't pick weight
        return knapsack(n-1, profits, weights, capacity)
    
    # return max of pick and not pick
    return max((profits[n-1] + knapsack(n-1, profits, weights, capacity-weights[n-1])), knapsack(n-1, profits, weights, capacity))

# dp
def knapsack_dp(n, profits, weights, capacity): 
    if n == 0 or not profits or not weights or capacity == 0:
        return 0
    
    dp = [[0 for _ in range(capacity+1)] for _ in range(n+1)]
    for i in range(1, n+1): # profits loop
        for w in range(1, capacity+1): # weights loop
            if weights[i-1] <= w:
                dp[i][w] = max(profits[i-1]+dp[i-1][w-weights[i-1]], dp[i-1][w])
            else:
                dp[i][w] = dp[i-1][w] 

    return dp[n][capacity]

def test_knapsack():
    test_cases = [
        (3, [60, 100, 120], [10, 20, 30], 50, 220),
        (3, [10, 20, 30], [1, 2, 3], 5, 50),
        (3, [10, 20, 30], [1, 2, 3], 6, 60),
        (3, [10, 20, 30], [1, 2, 3], 3, 30),
        (3, [10, 20, 30], [1, 2, 3], 0, 0),
        (1, [10], [5], 4, 0),
        (4, [1, 4, 5, 7], [1, 3, 4, 5], 7, 9),
        (4, [3, 4, 5, 8], [2, 3, 4, 5], 5, 8),
        (3, [10, 20, 30], [6, 7, 8], 5, 0),
        (4, [20, 5, 10, 40], [1, 2, 3, 8], 8, 40),
        (4, [10, 40, 30, 50], [5, 4, 6, 3], 10, 90)
    ]

    for i, (n, values, weights, capacity, expected) in enumerate(test_cases):
        # result = knapsack(n, values, weights, capacity)
        result = knapsack_dp(n, values, weights, capacity)
        assert result == expected, f"Test case {i+1} failed: expected {expected}, got {result}"
        print(f"Test case {i+1} passed: expected {expected}, got {result}")

# Run the test function
test_knapsack()