#Time complexity: O(n*W) where n is the number of weights array and W is the total capacity
#Space complexity: O(n*W) where n is the number of weights array and W is the total capacity
#Not available of leetcode
#Approach: dp is a 2D array where 1 to W works as columns and individual weights as row. 2 cases - 1. where we dont take ith 
#item for jth capacity 2. where we take maximum of  "previous item with current capacity" and "fill current item with ith 
#value + value of item with weight at j-last item weight" 
def knapsack(W, weights, values):
	dp = [[0]*(W+1) for _ in range(len(weights)+1)]

	for i in range(len(weights)+1):
		for j in range(W+1):
			if i==0 or j==0:
				dp[i][j] = 0
			elif weights[i-1] <=j: 
				dp[i][j] = max(values[i-1] + dp[i-1][j-weights[i-1]], dp[i-1][j])
			else:
				dp[i][j] = dp[i-1][j]

	return dp[len(weights)][W] 