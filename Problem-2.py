'''
    Time Complexity: O(n"2)
    Space Complexity: O(n)
    Approach: Used Dynamic Programming. 
            Stored either previous value if j < wt, else sotre the max of previous value or current value + subproblem
            Return the final value. 
'''
def knapSack(W, wt, val, n):
    dp = [0 for j in range(W+1)]
    for j in range(W+1):
        dp[0] = 0
    for i in range(1, n+1):
        temp = dp[:]
        for j in range(W+1):
            if j < wt[i-1]:
                dp[j] = temp[j]
            else:
                dp[j] = max(temp[j], val[i-1] + temp[j - wt[i-1]])
    return dp[W]