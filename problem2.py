0/1 Knapsack Problem:
# Time complexity is O(N*C) and space complexity is O(N*C)
class Solution:
  def solveKnapsack(self, profits, weights, capacity):
      dp = [[-1 for x in range(capacity+1)] for y in range(len(profit))]
      return self.recursive(profits, weights, capacity, 0, dp)
  
  def recursive(self, profits, weights, capacity, index), dp:
      if capcity <=0 or index>= len(profits):
          return 0
      
      if dp[index][capacity] != -1:
          return dp[index][capacity]
      
      profit1 = 0
      
      if weights[index]>= capacity:
          profit1 =  profits[index] + self.recursive( profits, weights, capacity-weights[index], index+1, dp)
      profit2 =  self.recursive( profits, weights, capacity, index+1, dp)
      
      dp[index][capacity] = max(profit1, profit2)
    return max(profit1, profit2)