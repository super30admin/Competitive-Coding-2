# // Time Complexity : O(n*m)
# // Space Complexity : O(n*m)
# // Did this code successfully run on Leetcode : Couldn't find on leetcode
# // Any problem you faced while coding this : No

def knapSack(val, wt, cap): 
    dp = [[0 for _ in range(cap + 1)] for _ in range(len(wt)+ 1)] 
    
    # Build table dp[][] in bottom up manner 
    # store values in table using the items we have
    for i in range(len(wt) + 1): 
        for j in range(cap + 1): 
            if i == 0 or j == 0: 
                dp[i][j] = 0
            elif wt[i-1] <= j: 
                dp[i][j] = max(val[i-1] + dp[i-1][j-wt[i-1]],  dp[i-1][j]) 
            else: 
                dp[i][j] = dp[i-1][j] 
  
    return dp[len(wt)][cap] 
  
# Driver program to test above function 
val = [10, 15, 40] 
wt = [1, 2, 3] 
cap = 6
print(knapSack(val, wt, cap)) 
  