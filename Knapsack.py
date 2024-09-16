"""
// Time Complexity : o(n), where n  is the number of elements 
// Space Complexity : o(n), using a dictionary
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

"""

"""
Recursion
Time complexity : o(2^n)
Space complexity : o(n)
"""
class Solution:

   def knapsack(self, capacity, profit, weights, n): #function call
       return self.helper(capacity, profit, weights, n, 0, 0)

   def helper(self, rem_cap, profit, weights, n, i, max_prof):
       #base
       if i >= n or rem_cap == 0: #if remaining capacity is exhausted or we have considered all the items then return max profit
           return max_prof

       #logic
       if weights[i] > rem_cap:
           return self.helper(rem_cap, profit, weights, n, i+1, max_prof)

       case0 = self.helper(rem_cap, profit, weights, n, i+1, max_prof) #if we don't choose the item

       case1 = self.helper(rem_cap - weights[i], profit, weights, n, i+1, max_prof + profit[i]) #if we choose the item

       return max(case0, case1) #return max since we want maximum profit

"""
DP
Time complexity : o(m*n), m is capacity and n is number of items
Space complexity : o(m*n)
"""
class Solution:

   def knapsack(self, capacity, profit, weights, n):

       dp = [[0 for i in range(capacity+1)] for j in range(n+1)] #dp matrix

       for i in range(0, n+1): #for all items
           for w in range(0, capacity+1): 
               if i == 0 or w == 0: #setting first row and column = 0
                   dp[i][w] = 0

               elif w < weights[i-1]: #till w is not equal or greater than weights[i-1], get values from the previous row
                   dp[i][w] = dp[i-1][w ]
               
               else:
                   dp[i][w] = max(dp[i-1][w], dp[i-1][w-weights[i-1]]+profit[i-1]) #else, max of choose or not choose

       return dp[n][capacity]