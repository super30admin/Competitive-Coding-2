"""
Given weights and values of n items, put these items in a knapsack of capacity W to get the maximum total value in the knapsack. 
In other words, given two integer arrays val[0..n-1] and wt[0..n-1] which represent values and weights associated with n items respectively. 
Also given an integer W which represents knapsack capacity, find out the maximum value subset of val[] such that sum of the weights of this subset is 
smaller than or equal to W. You cannot break an item, either pick the complete item or don’t pick it (0-1 property).

Example:
    value = [60, 100, 120]
    weight = [10, 20, 30]
    W=50

    weight (30 + 20) value = (120, 100)

brute force:
    exponential solution
    def knapSack (maxWeight, weights, values):
        return helper(maxWeight, weights, values, len(values)-1)

    def helper(maxWeight, weights, values, n):
        #base
        if(n == 0 || maxWeight ==0):
            return 0
        
        if(weights[n] > max):
            return helper(maxWeight, weights, value, n-1)
        else:
            return max(value[n-1] + helper(maxWeight-weights[n-1], weights, values, n-1), 
                        helper(maxWeights, weights, values, n-1))
        

"""
"""
dynamic programming approach
    build a 2d array with rows as len(weights)+1 and columns as maxWeight+1

                0 if i=0 or j=0
    dp[i][j] =  max(value[i-1] + dp[i-1][j-weights[i-1]], dp[i-1][j]) if weights[i-1] <= j
                else dp[i-1][j]
    
    return the last element in 2d array

    Time Complexity: O(n*W) n -> length of weights, W - max weight
    space Complexity : O(n*W)
"""
def knapSack(maxWeight, weights, values):
    dp = []
    dp.append([0]*(maxWeight + 1))
    for i in range(1, len(weights)+1):
        dp.append([0])
        for j in range(1, maxWeight+1):
            if(weights[i-1] > j):
                dp[i].append(dp[i-1][j])
            else:
                dp[i].append(max(values[i-1] + dp[i-1][j - weights[i-1]], dp[i-1][j]))
    return dp[-1][-1]


print(knapSack(6, [1,2,3], [10,15,40]))
print(knapSack(50, [10,20,30], [60,100,120]))