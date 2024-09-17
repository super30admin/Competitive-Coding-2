# In the Dynamic programming we will work considering the same cases as mentioned in the recursive approach. 
# In a DP[][] table let’s consider all the possible weights from ‘1’ to ‘W’ as the columns and weights that can be kept as the rows. 
# The state DP[i][j] will denote maximum value of ‘j-weight’ considering all values from ‘1 to ith’. 
# So if we consider ‘wi’ (weight in ‘ith’ row) we can fill it in all columns which have ‘weight values > wi’. 
# Now two possibilities can take place: 

# Fill ‘wi’ in the given column.
# Do not fill ‘wi’ in the given column.
# Now we have to take a maximum of these two possibilities, formally if we do not fill ‘ith’ weight in ‘jth’ column then DP[i][j] state will be same as DP[i-1][j] but if we fill the weight, DP[i][j] will be equal to the value of ‘wi’+ value of the column weighing ‘j-wi’ in the previous row. So we take the maximum of these two possibilities to fill the current state.

# Time Complexity: O(N*W); where N is the number of weights and W is the total capacity
# Space Complexity: O(N*W)

class Solution:

	def Knapsack(self, val,wt,W):
		rows = len(val) + 1
		cols = W + 1

		dp = [[0 for i in range(cols)] for j in range(rows)]

		for r in range(rows):
			dp[r][0] = 0

		for c in range(cols):
			dp[0][c] = 0

		for i in range(1, rows):
			for j in range(1, cols):

				if j < wt[i-1]:
					dp[i][j] = dp[i-1][j]
				else:
					dp[i][j] = max(dp[i-1][j], val[i-1] + dp[i-1][j-wt[i-1]])

		print(dp)

val = [10, 15, 40] 
wt = [1, 2, 3] 
W = 6
n = len(val) 

s = Solution()
s.Knapsack(val,wt,W)