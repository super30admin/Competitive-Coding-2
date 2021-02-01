// Time Complexity : O(n*m)     \\n=len(capacity)+1   \\m=len(weight)+1
// Space Complexity : O(n*m)

// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
weight=[2,3,4,5]
profit=[1,2,5,6]
capacity=8

dp=[[0]*(capacity+1) for i in range(len(weight)+1)]
for i in range(1,len(dp)):
	for j in range(1,len(dp[0])):
		if weight[i-1]>j:	#weight>capacity
			dp[i][j]=dp[i-1][j]
		else:
			dp[i][j]=max(profit[i-1]+ dp[i-1][j-weight[i-1]],dp[i-1][j-1])
print(dp)
print(dp[-1][-1])
