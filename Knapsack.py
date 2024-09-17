'''Complexity Analysis
Time Complexity: O(NxW) --> Iterating through all items for all weights from 0 to W.
Space Complexity: O(W) --> One dimensional dp array of size W.
'''

# Returns the maximum value that
# can be put in a knapsack of
# capacity W
 
def knapSack(W, wt, val, n):
    dp = [0]*(W+1) 
    # For all items   
    for i in range(n):
        new_dp = [0]
        # For all weights from 0 to W
        for w in range(1,W+1):
            i_weight, i_val = wt[i], val[i]
            # If current weight > capacity, continue
            if (i_weight > w):
                new_dp.append(dp[w])
                continue            
            # Maximum of (skip or pick).
            new_dp.append(max(dp[w], i_val + dp[w-i_weight]))
        # Update dp
        dp = new_dp
    return dp[W]
        
    # ### Recursion with memoization
    # memo = {}
    
    # def helper(index=0, rem_wt=W):
        
    #     ### Base Case
    #     if rem_wt < 0:
    #         return float('-inf')
        
    #     if rem_wt == 0 or index==n:
    #         return 0
        
    #     if (index, rem_wt) in memo:
    #         return memo[(index, rem_wt)]
                
    #     ### Logic
    #     skip_val = helper(index+1, rem_wt)                           # Skip
    #     pick_val = val[index] + helper(index+1, rem_wt-wt[index])    # Pick        
    #     memo[(index,rem_wt)] = max(skip_val, pick_val)
    #     return memo[(index, rem_wt)]
    
    # return helper()

# Driver code
val = [60, 100, 120]
wt = [10, 20, 30]
W = 50
n = len(val)
print(knapSack(W, wt, val, n))