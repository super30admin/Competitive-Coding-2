
""""// Time Complexity : O(mn)
// Space Complexity :O(mn)
m= number of values+1
n= capacity+1
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
"""
def maxVal(val, wt, W):
    n=W
    m=len(val)
    dp = [[0 for i in range(n+1)] for j in range(m+1)]
    for i in range(1,m+1):
        for j in range(1,n+1):
            if j<wt[i-1]:
                dp[i][j]=dp[i-1][j]

            dp[i][j]=max(dp[i-1][j], dp[i-1][j-wt[i-1]]+val[i-1])
    return dp[m][n]
val = [10, 15, 40]
wt = [1, 2, 3]
W = 6
print(maxVal(val, wt, W))




# EXHAUSTIVE APPROACH(RECURSION)-
#
# """"// Time Complexity : O(2^n)
# // Space Complexity :
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this :
# """
#
#
# def maxVal(val, wt, W):
#     return helper(val,wt,W,0,0)
# def helper(val, wt, W, i, maxval):
#     #base
#     if i==len(val):
#         return maxval
#     if W<0:
#         return -1
#
#
#     # logic
#
#     case1=helper(val, wt, W-wt[i], i+1, maxval+val[i])
#     case2 = helper(val, wt, W, i + 1, maxval)
#
#     return max(case1, case2)
#
# val = [10, 15, 40]
# wt = [1, 2, 3]
# W = 6
# print(maxVal(val, wt, W))
#
#
