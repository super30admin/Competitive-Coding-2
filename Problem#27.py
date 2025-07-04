'''
Problem Name: Interview Problem: 0-1 Knapsack Problem

Source Link: https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/

0-1 Knapsack Problem | DP-10
we are given weights and values of n items. we need to put these items in a knapsack of capacity W to get maximum value in our knapsack.

or we can say that we are given two integers arrays val[0......n-1] and wt[0.....n-1] which represent values and weights associated with n items respectively. we are also given an integer W  which represents knapsack capacity.

find out the maximum value subset of val[] such that sum of the weights of this subset is smaller than or equal to W. but you cannot break an item, either pick the complete item or dont pick it(known as 0-1 property).


'''

# Time Complexity : O(n * W) where n is the number of items and W is the maximum weight capacity of the knapsack
# Space Complexity : O(n * W) for the 2D dp array used to store the maximum profit for each item and capacity combination
# Did this code successfully run on Leetcode : Yes, the code runs successfully for the test case provided
# Any problem you faced while coding this : Yes, understanding the 0-1 knapsack problem and how to implement the dynamic programming solution was a bit challenging, but once the logic was clear, it was straightforward to implement.


class Solution:
    
    @staticmethod # This method is static so it can be called without creating an instance of the class
    def findMax(weights, profit, totalCapacity): # weights is a list of weights, profit is a list of profits, and totalCapacity is the maximum weight capacity of the knapsack
        n = totalCapacity # totalCapacity is the maximum weight capacity of the knapsack
        m = len(weights) # m is the number of items (length of the weights list)
        dp = [[0] * (n + 1) for _ in range(m + 1)] # Create a 2D list dp with (m + 1) rows and (n + 1) columns initialized to 0

        for i in range(1, m + 1): # Iterate over each item (1 to m)
            for j in range(1, n + 1): # Iterate over each capacity (1 to n)
                if weights[i - 1] > j: # If the weight of the current item is greater than the current capacity
                    dp[i][j] = dp[i - 1][j] # Do not include the item, carry forward the previous value
                else: # If the weight of the current item is less than or equal to the current capacity
                    dp[i][j] = max(dp[i - 1][j], profit[i - 1] + dp[i - 1][j - weights[i - 1]]) # Choose the maximum between not including the item or including it (adding its profit and reducing the capacity by its weight)
        
        return dp[m][n] # Return the maximum profit that can be obtained with the given weights and profits within the total capacity

# Test
items = [10, 20, 30, 40] # weights of the items
profit = [130, 110, 170, 190] # profits of the items
capacity = 50 # maximum capacity of the knapsack
print(Solution.findMax(items, profit, capacity)) # Output: 320, which is the maximum profit that can be obtained with the given weights and profits within the total capacity