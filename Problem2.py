# Problem link : https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/
# Time Complexity : O(n * m)
#  Space Complexity : O(n * m)
#  Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
'''
        Basic approach : 1. O(2^n) => Create a recursive tree of choosing or not choosing the current index weight. Once we have reached the leaf node we compute the values corresponding to each weight we have chosen in the current path and get min of the two paths for each root node
        At each node there are two options hence time complexity is 2^n and space complexity is O(n) as at a time there can be only n elements present in the memory stack for recursive calls. Once we have reached the end, we go back in the recursive call stack and start traversing the new path
		Slight optimization to this can be done by memoization.

        Optimized approach: O( n * m ) => Maintain a DP matrix with number of rows representing the weight array(corresponding value from the same index can be fetched to compute total value)
        and columns with the size of maximum capacity.
        The intuition behind this approach is we have a constraint of capacity of weights as W so at each step we can calculate the max value for each capacity value. At the end the last value is our maximum possible value for capacity

'''

def knapSack(W, wt, val, n):
	if not wt or not val or W <= 0:
		return 0
	# initalize dp matrix with colums as max capacity W and rows as length of weight/val. 1 extra element to store 0 for both row and col
	dp = [[0 for _ in range(W+1)] for _ in range(n+1)]
	for i in range(n+1):
		for j in range(W+1):
			if j < wt[i-1]:
				dp[i][j] = dp[i-1][j]
			else:
				# choose current weight = current value + remaining amount from dp matrix
				c = val[i-1] + dp[i-1][j-wt[i-1]]
				# dont choose current weight
				dc = dp[i-1][j]

				dp[i][j] = max(c,dc)
	return dp[-1][-1]

val = [60, 100, 120] 
wt = [10, 20, 30] 
W = 50
n = len(val) 
print(knapSack(W, wt, val, n))