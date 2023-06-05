"""
Time Complexity: O(n*m), n is capacity, m is the total number of items
Space Complexity: O(n)

Problem_1: 0-1 Knapsack Problem
Example:
Input: Weight = [10,20,30], W = 50, Values = [60, 100, 120]
Output: 220
"""

#Using bottom up dynamic prog, we will be taking matrix of the capacity with the items array.
    cal the values w.r.t each cell

def knapsack_dp(self, weight, values, capacity):
    
    if(len(weight) == 0) or (len(values)==0) or len(values) != len(weight):
        return 0
    # defining row for the table
    m = len(values)
    n = capacity
    #creating dp table
    dp = [[0 for i in range(n+1)] for j in range(m+1)] 

    for r in range(1, len(dp)):
        for c in range(1, len(dp[0])):                    
            if c < weight[r - 1]:
                dp[r][c] = dp[r - 1][c]
            else:
                dp[r][c] = max(dp[r - 1][c], values[r - 1] + dp[r - 1][c - weight[r - 1]])
                
    return dp[m][capacity]