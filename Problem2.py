#0-1 Knapsack Problem
#Time Complexity : O(n*m)
# Space Complexity : O(n*m) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

#Approch: Using the dp matrix approach, we calculate the profit for each combination of capacity and weights. 
# For the next elements, we compare the max profit from previous computed profit and profit at that place.
w=[2,3,5]
p=[1,2,6]
c=8
def max_profit(w,p,c):
    dp=[[0 for i in range(c+1)] for j in range(len(w)+1)]
    for i in range(0, len(w)+1):
        for j in range(0,c+1):
            if i==0 or j==0:
                dp[i][j]=0
            elif j < w[i-1]:
                dp[i][j]=dp[i-1][j]
            else:
                dp[i][j]= max(dp[i-1][j], p[i-1]+dp[i-1][j-w[i-1]])
    return dp[-1][-1]
profit=max_profit(w,p,c)
print(profit)