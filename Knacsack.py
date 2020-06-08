  ---------------------- KnapSack Problem  Dynamic Programming------------------------------------------------   
# Time Complexity : O(NXM) N is the length of the weights, M is the weight.
# Space Complexity : O(MXN)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# 
# To calculate the maximum profit, we can have a dp array which stores the profit by using the different weights, If the weight calculated<weight wehave
#then we can choose the profit of previous row, else we can take the minimum weight of the previous row and weight-weights[i]+profit of choosing this weight.

class Solution:
    def knapsack(self, weights: List[int], weight: int, profit:List[int]) -> int:

		if not weights or weight == 0:
			return 0

		M = len(weights)
		N = weight/10

		dp =  [[0 for i in range(N+1)] for j in range(M+1)]

		for i in range(1,len(dp)):
			for j in range(len(dp[0])):
				if weights[i-1] > j:
					dp[i][j] = dp[i-1][j]
				else:
					dp[i][j] = max(dp[i-1][j], dp[i-1][j-weights[i-1]]+profit[i-1])
		return dp[-1][-1]


---------------------------------------- BruteForce Recursion approach --------------------------------------------------------
# Time Complexity : O(2**N) N is the length of the weights.
# Space Complexity : O(MXN)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# 
# To calculate the maximum profit, we have 2 options, either we can choose the weight or not choose the weight.  If the weight is chosen, we can recurse the remaining weight by taking the difference.
# and add the profit by choosing that weight. If it is not chosen, then we have the same profit of not choosing and recurse until we reach end of the weights.

	def knapsack(profit, weights, weight):
		if not weights or weight == 0:
			return 0
	
		def recursion(index, profit, weights, weight, Max_profit):
			# EdgeCase
			if index == len(weights) or weight <0:
				return 0
	
		
			# Logic
		
			case1 = recursion(index+1, profit, weights, weight-weights[index], Max_profit+profit[index])
			case2 = recursion(index+1, profit, weights, weight, Max_profit)
		
			return max(case1, case2)
		
		return recursion(0,profit,weights,weight,0)
