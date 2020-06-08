# Time Complexity : O(n x m) [n = number of weights, m = capacity ]

# Space Complexity : O(n x m) [n = number of weights, m = capacity ]

# Did this code successfully run on Leetcode : N/A

# Three line explanation of solution in plain english
# 1. The values in the dp array filled out on the basis of put the current weight in bag or not
# 2. The decision which leads to max value is chosen
def knapsack(w,v,cap):
	dp  = [[0 for col in range(cap+1)] for row in range(len(w)+1)]
	for i in range(1, len(w)+1):
		for j in range(1, cap+1):
			if j < w[i-1]:
				dp[i][j] = dp[i-1][j]
			else:
				case_0 = dp[i-1][j]
				case_1 = v[i-1] + dp[i-1][j-w[i-1]] # If there were infinite supply of weight then we would have chosen dp[i][j-w[i-1]], but since the chosen weight is gone we have to shift to the previous row
				dp[i][j] = max(case_0, case_1)
	return dp[len(w)][cap]


testcases = [[[1, 5, 2, 6], [20, 20, 30, 50], 8], [[20,10,10], [30,20,40], 10],
             [[1, 8, 12, 6], [40, 13, 45, 10], 20],
             [[48, 72, 30, 52, 80, 58, 92, 55, 85, 50, 35, 60, 82, 64, 88, 37, 99, 94, 91, 39, 42, 97, 45, 47, 69, 61, 57, 40, 41, 86, 77, 54, 98, 87, 63, 70, 76, 93, 67, 46, 43, 59, 73, 71, 62, 51, 33, 89, 38, 49], [166, 114, 159,154, 94, 191, 105, 64, 23, 42, 18, 129, 185, 133, 171, 134, 168, 16, 68, 11, 80, 150, 62, 47, 182, 142, 93, 112, 137, 33, 153, 11, 99, 180, 176, 49, 105, 152, 180, 124, 160, 29, 62, 197, 28, 45, 37, 119, 32, 147], 456]]

for i in testcases:
    print(knapsack(i[0], i[1], i[2]))