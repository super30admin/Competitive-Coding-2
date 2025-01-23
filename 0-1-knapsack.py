"""

Given N items where each item has some weight and profit associated with it and also given a bag with capacity W, [i.e., the bag can hold at most W weight in it]. 
The task is to put the items into the bag such that the sum of profits associated with them is the maximum possible. 

Note: The constraint here is we can either put an item completely into the bag or cannot put it at all [It is not possible to put a part of an item into the bag].

Input: N = 3, W = 4, profit[] = {1, 2, 3}, weight[] = {4, 5, 1}
Output: 3
Explanation: There are two items which have weight less than or equal to 4. If we select the item with weight 4, the possible profit is 1. 
And if we select the item with weight 1, the possible profit is 3. So the maximum possible profit is 3. Note that we cannot put both the items with weight 4 and 1 together as the capacity of the bag is 4.


Input: N = 3, W = 3, profit[] = {1, 2, 3}, weight[] = {4, 5, 6}
Output: 0

Time Complexity: O(n * w) for both methods
Space Complexity: O(n * w) for method 1 (using 2d dp) and O(w) for method 2 (using 1d dp)

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

"""

# Approach: We solve the 0/1 Knapsack problem using dynamic programming.
# The first approach uses a 2D table (dp[][]) for storing subproblem solutions,
# while the second approach optimizes space using a 1D array (dp[]).

def knapsack_2d(w, weight, profit):

    # method 1:
    # Time Complexity: O(n * w)
    # Space Complexity: O(n * w)
    
    n = len(weight)
    dp = [[0] * (w + 1) for _ in range(n + 1)]
    
    for i in range(1, n + 1):
        for j in range(1, w + 1):
            if weight[i - 1] <= j:
                dp[i][j] = max(profit[i - 1] + dp[i - 1][j - weight[i - 1]], dp[i - 1][j])
            else:
                dp[i][j] = dp[i - 1][j]
    
    return dp[n][w]

    # method 2:
    # Time Complexity: O(n * w)
    # Space Complexity: O(w)
    
    n = len(weight)
    dp = [0] * (w + 1)
    
    for i in range(n):
        for j in range(w, weight[i] - 1, -1):
            dp[j] = max(profit[i] + dp[j - weight[i]], dp[j])
    
    return dp[w]
    
