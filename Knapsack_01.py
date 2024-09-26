# TC: O(n x W)
# SC: O(n x W)
# Approach: Convert recursive brute forcw with exponential time complexity into memoized dynamic programming solution
#           Memoization helps to eliminate excess function calls by remembering the answers to repeating sub-problems

def knapSack(W, wt, val, n):
 
    dp = [[ 0 for _ in range(W + 1)] for _ in range(n + 1)]
    
    for i in range (1, len(dp)):
        for j in range(1, len(dp[0])):
            # if the current weight exceeds the weight of the current item then the knapsack cannot accomodate the current item
            if j < wt[i - 1]:
                dp[i][j] = dp[i - 1][j]
            # else take the max of values of selecting and not selecting current item
            else:
                dp[i][j] = max(dp[i - 1][j], val[i -1] + dp[i - 1][j - wt[i - 1]])
                
    return dp[n][W]
