#Time Complexity : O(W*n) where n is the length of the values and W is the total value we want
#Space Complexity : Q(W*n) where n is the length of the values and W is the total value we want

#Did this code successfully run on Leetcode : Coudln't test on Leetcode but ran for 3-4 examples I tested

#Three line explanation of solution in plain english: Make a DP 2-D array for our two constraints, the weight and the total value we want. Iterate the through the 2-D array, updating values by either taking the value from above weights if we don't have enough weights and if we do then take max of prev max (i.e. by excluding the current weight) or value of that weight plus the amount we've gotten till now (i.e. by including the current weight).

#Your code here along with comments explaining your approach

def knapSack(W, weights, values):
    n = len(values)
    dp = [[0 for _ in range(W+1)] for _ in range(n+1)]

    for i in range(1, len(dp)):
        for j in range(1, len(dp[0])):
            #amount of weight we have i.e. j is less than weight we need to consider
            if wt[i-1] > j:
                dp[i][j] = dp[i-1][j]
            #get max weight by either including the current weight or not including the current weight
            else:
                dp[i][j] = max(dp[i-1][j], dp[i-1][j-(wt[i-1])]+val[i-1])

    return dp[n][W]
