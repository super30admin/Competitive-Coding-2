"""
Intuition:  Check greedy. 
Greedy fails if values = [50,60,100,50], weight = [10,10,50,10], Weight Limit = 50

This means we need to get all possible combinations of the value and weights. ( Be exhaustive) 

Draw the recursive tree.
Repeated subproblems exist. 
Number of contraints: 2 - 1) Total Weight limit, 2) Weights array
#####################################################################
Recursive Approach:
Time Complexity : O(2^n) where n = number of weights/values
Space Complexity : O(2^n) where n = number of weights/values

#####################################################################
Dynamic Programming Approach:
Time Complexity : O(weightLimit *  values) 
Space Complexity : O(weightLimit *  values) 
#####################################################################

"""

#DynamicProgramming
def knapSackUsingDP(values, weights, totalWeight):

    dp = [[0 for j in range(totalWeight + 1)] for i in range(len(weights) + 1)]
    for i in range(1, len(weights) + 1):
        for j in range(1, totalWeight + 1):

            currentWeight = weights[i-1]
            currentTotalCapacity = j 
            if currentWeight > currentTotalCapacity:
                dp[i][j] = dp[i-1][j]
            elif currentWeight <= currentTotalCapacity:
                dp[i][j] = max(dp[i-1][j], values[i-1] + dp[i-1][currentTotalCapacity - currentWeight])
    return dp[-1][-1]


values = [50,60,100,10]
weights = [1,1,10,1]
totalWeight = 10
print(knapSackUsingDP(values, weights, totalWeight))
