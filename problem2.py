# 0-1 Knapsack

# // Time Complexity : O(n*m) n=capacity, m=length of the weight array
# // Space Complexity :O(n*m)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no



def knapsack(value, weight, W):
    dp = [[0 for i in range(W+1)  ] for j in range(len(weight)+1)]

    for i in range(len(dp)) :
        for j in range(len(dp[0])):
            if i==0 or j==0:
                continue
            elif(weight[i-1]>j):                    #if the current weight is greater than the capacity, the value should be the same as the value for the last weight
                dp[i][j]=dp[i-1][j-1]
            else:
                dp[i][j] = max(dp[i-1][j-1], value[i-1] + dp[i-1][j-weight[i-1]])               #max value of either the previous weight or the value of current weight + value of next iteration
    return dp[len(weight)][W]


#testing
value = [60,100,120]
weight= [10,20,30]
W=50
print(knapsack(value, weight,W))