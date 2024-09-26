
# 0-1 Knapsack Problem | DP-10
# we are given weights and values of n items. we need to put these items in a knapsack of capacity W to get maximum value in our knapsack.
# or we can say that we are given two integers arrays val[0......n-1] and wt[0.....n-1] which represent values and weights associated with n items respectively. we are also given an integer W  which represents knapsack capacity.
# find out the maximum value subset of val[] such that sum of the weights of this subset is smaller than or equal to W. but you cannot break an item, either pick the complete item or dont pick it(known as 0-1 property).


# Optimized solution

# Approach: Recursive code of choose and dont choose with memoization [DP].
def helper(weight, value, maxx, n ):

    dp = [[-1 for _ in range(maxx+1)] for _ in range(n+1)]

    if n==0:
        return 0
    
    if dp[n][maxx]!=-1:
        return dp[n][maxx]

    if  maxx- weight[n-1]>=0:
        dp[n][maxx] =  max(value[n-1]+helper(weight, value, maxx-weight[n-1], n-1), helper(weight, value, maxx, n-1))
        return dp[n][maxx]
    else:
        dp[n][maxx] =  helper(weight, value, maxx, n-1)
        return dp[n][maxx]


weight = [2,3,5]
value = [1,2,6]
maxx = 8
n = len(weight)

print(helper(weight, value, maxx, n))

# Time Complexity = O(N*M)
# Space Complexity = O(N*M)
# Passed the testcases: YES.
# Difficulty faced : A little.
