# 0-1 Knapsack Problem - Dynamic Programming

# Program for 0-1 Knapsack problem
# Returns the maximum value that can
# be put in a knapsack of capacity W

# Time Complexity : O(mn) m = len(weights), n = W
# Space Complexity : O(mn)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no


def knapSack(W, weights, profit):
	
	dp = [[0 for j in range(W+1)] for i in range(len(weights)+1)]
	
	for i in range(1,len(weights)+1):
		for j in range(1,W+1):
			if weights[i-1] > j:
				dp[i][j] = dp[i-1][j]
			else:
				dp[i][j] = max(dp[i-1][j], profit[i-1] + dp[i-1][j-weights[i-1]])
	

	return dp[len(weights)][W]


# Driver code
if __name__ == '__main__':
	profit = [60, 100, 120]
	weights = [10, 20, 30]
	W = 50
	print(knapSack(W, weights, profit))

