'''
0-1 Knapsack Problem | DP-10

Given n items, each with a specific weight and price, and a knapsack with a capacity of W, the task is to put the items in the knapsack such that the sum of weights of the items <= W and the sum of prices associated with them is maximized.

Note: You can either place an item entirely in the bag or leave it out entirely (known as 0-1 property). Also, each item is available in single quantity.

Example 1:
Input: W = 5, prices = [10, 40, 30, 50], weights = [5, 4, 2, 3]
Output: 80
Explanation: Choose the third item (value 30, weight 2) and the last item (value 50, weight 3) for a total value of 80.

Solution:
1. Brute Force (recursion): Exhaustive approach. For each weight, choose whether to pick or no pick. If there are  4 weights, then we have multiple combinations: [0,0,0,0] (no weights picked), [0,0,0,1] (last wt picked), [0,0,1,1] (last two wts picked), ... . There are 2^4 such possibilities.
Time: O(2^N), Space: O(N)

2. DP tabulation: Initialize a 2D DP array of size (N+1) x (Capacity + 1).
Fill first row and first col with 0s.
Then for the remaining rows and cols, run
for i in range(1, N+1):
    for j in range(1, M +1):
        if j < weights[i-1]:
            dp[i][j] = dp[i-1][j]
        else:
            dp[i][j] = max(dp[i-1][j], dp[i-1][j-weights[i-1]] + prices[i-1])
Return dp[N][M]

Time: O(NM), Space: O(NM), N = num weights, M = capacity
'''

import time
def knapsack_01(weights, prices, capacity):
    def recurse(weights, prices, index, capacity, profit):
        N = len(weights)

        if capacity < 0:
            return 0

        if index == N or capacity == 0:
            return profit

        case_0 = recurse(weights, prices, index+1, capacity, profit)
        case_1 = recurse(weights, prices, index+1, capacity - weights[index], profit + prices[index])

        m = max(case_0, case_1)
        return m

    if capacity == 0:
        return 0
    return recurse(weights, prices, 0, capacity, 0)

def knapsack_01_dp(weights, prices, capacity):
    N = len(weights)
    if N == 0 or capacity <= 0:
        return 0

    dp = [[0]*(capacity + 1) for _ in range(N+1)]

    for i in range(1,N+1):
        for j in range(1, capacity+1):
            if j < weights[i-1]:
                dp[i][j] = dp[i-1][j]
            else:
                dp[i][j] = max(dp[i-1][j], dp[i-1][j-weights[i-1]] + prices[i-1])
    return dp[N][capacity]

def run_knapsack_01():
    tests = [ ([5,4,2,3], [10,40,30,50], 5, 80),
              ([2,3,4,5], [1,2,5,6], 8, 8),
              ([2,1,5,3], [300,200,400,500], 10, 1200),
              ([10,20,30], [60,100,120], 50, 220),
            ]
    for test in tests:
        weights, prices, capacity, ans = test[0], test[1], test[2], test[3]
        start = time.time()*1000
        profit = knapsack_01(weights, prices, capacity)
        elapsed =  time.time()*1000 - start
        print(f"\nWeights = {weights}, Prices = {prices}, Max capacity = {capacity}")
        print(f"Max profit = {profit}, time = {elapsed:.2f} ms (recursion)")
        print(f"Pass: {ans == profit}")

    for test in tests:
        weights, prices, capacity, ans = test[0], test[1], test[2], test[3]
        start = time.time()*1000
        profit = knapsack_01_dp(weights, prices, capacity)
        elapsed =  time.time()*1000 - start
        print(f"\nWeights = {weights}, Prices = {prices}, Max capacity = {capacity}")
        print(f"Max profit = {profit}, time = {elapsed:.2f} ms (dp tabulation)")
        print(f"Pass: {ans == profit}")

run_knapsack_01()