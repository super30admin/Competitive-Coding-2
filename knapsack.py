# // Time Complexity : O(n*capacity) where n is the number of items and 
# capacity is the weight limit on the bag
# // Space Complexity : O(n*capacity) 
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : none

# // Your code here along with comments explaining your approach
def knapsack(profits, weights,capacity):

    dp = [[0 for _ in range(capacity+1)] for _ in range(len(profits)+1)]

    # for j in range(len(dp[0]))

    for i in range(1,len(dp)):
        for j in range(1,len(dp[0])):
            if j < weights[i-1]:
                dp[i][j] = dp[i-1][j]
            else:
                dp[i][j] = max(dp[i-1][j], profits[i-1] + dp[i][j-weights[i-1]])
    
    return dp[-1][-1]

profits = [1,2,6]
weights = [2,3,5]

print(knapsack(profits,weights,8))