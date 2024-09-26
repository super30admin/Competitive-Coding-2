'''
====== Submission Details =======
Student Name: Pavan Kumar K. N.
S30 SlackID : RN32MAY2021
=================================
'''
# Given weights and values of n items, put these items in a knapsack of 
# capacity W to get the maximum total value in the knapsack. 
# In other words, given two integer arrays val[0..n-1] and wt[0..n-1]
# which represent values and weights associated with n items respectively.
# Also given an integer W which represents knapsack capacity, find out 
# the maximum value subset of val[] such that sum of the weights of this 
# subset is smaller than or equal to W. You cannot break an item, either pick
# the complete item or don’t pick it (0-1 property).

# https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/


#-----------------
# Time Complexity: 
#-----------------
# O(N*W): Need to iterate over every combination of N and W once. Where N
#         is the number of elements and W is the capacity. 
#         We consider all possible capacities between 1 and given capacity 
#         (W).
#------------------
# Space Complexity: 
#------------------
# O(W) - Need an array to store dp[] with values ranging from 1...W where W
#        is the capacity

#-----------------------
# Leet Code Performance: 
#-----------------------
# Ran Successfully?: N/A (Question not on leetcode)

# Similar to Coin Change problem where we had to find minimum number of coins

from typing import List
class Solution:
    def knapsack(self, capacity: int, weights: List[int], values: List[int]):
        # Create DP array to store possible allocations with weights ranging
        # from 0 to capacity. hence we need 1 extra element.
        dp = [0] * (capacity+1)

        n = len(weights)

        for i in range(1, n+1):
            for w in range(capacity, 0, -1):
                if weights[i-1] <= w:
                    dp[w] = max(dp[w], (dp[w-weights[i-1]] + values[i-1]))

        return dp[capacity]


obj = Solution()
print(obj.knapsack(50, [10, 20, 30], [60, 100, 120]))

print(obj.knapsack(3, [1, 2, 3], [10, 15, 40]))




