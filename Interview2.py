'''
Given 
weights w = [1, 2, 3] Max Capacity = 4
values  v = [2, 1, 10]
Find max value by selecting weights
Conditions:
1. total weight should be less then or equal to Max Capacity
1. Once selected weight, cannot select the same weight again

DP solution:


'''

# Time and space complexity is O(m*c) where m=len of weights list and c=max capacity
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
def maximizeValue(weights: 'list[int]', values:'list[int]', wcap: int):
    # dp matrix: 
    #   (0 to wcap+1) columns ==> total capacity is col_index
    #   (0 to len(weights)+1) rows ==> weights used are weights[0:row_index]
    # Both rows and columns start with 0
    # dp matrix holds "max value" achievable for ith row (=weights[0..i]) and jth col(wcap)
    dp = [[None for _ in range(wcap+1)] for _ in range(len(weights)+1)]

    # for weight=0, max cap is never reached and max value = 0
    for j in range(len(dp[0])):
        dp[0][j] = 0
    
    for i in range(1, len(weights)+1): # rows
        for j in range(wcap+1): # cols
            current_weight = weights[i-1] # as i starts with 1 and weights list with 0
            if current_weight > j: # if j current_weight > current_capacity(j)
                dp[i][j] = dp[i-1][j]
            else:
                val0 = dp[i-1][j] # if not choosing current weight
                val1 = dp[i-1][j-current_weight] + values[i-1] # if choosing current weight

                dp[i][j] = max(val0, val1)
    

    return dp[len(dp)-1][len(dp[0])-1] # last value (or dp[-1][-1])




# try it
w = [1, 2, 3] 
cap = 4
v = [2, 1, 10]

print(maximizeValue(w, v, cap))