# Time Complexity : O(M*N) where m is the capacity and N is length of weights
# Space Complexity : O(M*N) dp Arr
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Somewhat..Coming up with recursive brute 
# force was good however creating the DP array needed to be drawn out on the whiteboard.



# Your code here along with comments explaining your approach
def getMaxProfit(profits, weights, capacity, index, amount):
    
#     #recursive brute force after drawing it
#     if capacity <= 0 or index >= len(profits):
#         return amount
        
#     #logic
#     #choose
#     case1 = 0
#     if capacity >= weights[index]:
#         case1 = getMaxProfit(profits, weights, capacity - weights[index], index+1, amount + profits[index])
#     #don't choose
#     case2 = getMaxProfit(profits, weights, capacity, index+1, amount)
    
#     return max(case1,case2)

    """
    Create DP array (matrix) where M is capacity size and N is the profits. 
    """
    dp = [[0 for j in range(capacity+1)] for i in range(len(profits)+1)]
    
    for i in range(0, len(dp)):
        dp[0][i] = 0
            
    for i in range(1, len(dp)):
        for j in range(len(dp[0])):
            if weights[i-1] <= j:
                dp[i][j] = max(dp[i-1][j], dp[i-1][j - weights[i-1]] + profits[i-1])
            else:
                dp[i][j] = dp[i-1][j]

    print(dp)
    return dp[len(profits)][capacity]

profits = [60, 100, 120]
weights = [10, 20, 30] 
capacity = 50
# should return 220

print(getMaxProfit(profits,weights,capacity,0,0))