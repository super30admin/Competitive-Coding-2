"""
Time Complexity: 
Space Complexity: 
Problem_1: 0-1 Knapsack Problem
Example:
Input: Weight = [10,20,30], W = 50, Values = [60, 100, 120]
Output: 220
"""

# Approach - 1

class Solution:
    def knapsack_recursive(self, weight, values, capacity):
        """
        We will be doing and exhaustive cycle, where we will consider each and every weight to match
        the capacity. We will be taking the last weight first.
        Time Complexity: O(2^n), n the number of weight
        Space Complexity: O(n)
        """
        if (len(weight) == 0 or len(values) == 0): return 0
        n = len(values)
        return self.helper(weight, values, capacity, n, 0 )
    
    def helper(self, weight, values, capacity, index, amount):
        # Base Case
        if index == 0 or capacity == 0:
            return amount
        
        # Logic - case_1 : when we choose the weight
        case_1 = self.helper(weight, values, capacity - weight[index - 1], index -1, amount + values[index -1])
        # when we do not choose the weight
        case_2 = self.helper(weight, values ,capacity , index - 1, amount)
        
        return max(case_1, case_2)

# Approach - 2
def knapsack_dp(self, weight, values, capacity):
    """
    Using bottom up dynamic prog, we will be taking matrix of the capacity with the items array.
    cal the values w.r.t each cell
    Time Complexity : O(N * M), N is the capacity and M is the total number of items
    Space Complexity : O(N)
    """
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