# Time Complexity : O(n*w)
# Space Complexity : O(n*w)
# Did this code successfully run on Leetcode : NA
# Any problem you faced while coding this :


# Your code here along with comments explaining your approach

def ks(arrp, arrw, w):

    dp = [[0 for i in range(w+1)] for i in range(len(arrp))]

    #base case
    for j in range(arrw[0], w+1):
        dp[0][j] = arrp[0]

    #recurrence relation

    for i in range(1, len(arrp)):
        for j in range(w+1):

            if j >= arrw[i]:
                dp[i][j] = max(dp[i - 1][j - arrw[i]] + arrp[i], dp[i - 1][j])
            else:
                dp[i][j] = dp[i - 1][j]


    return dp[-1][-1]
























