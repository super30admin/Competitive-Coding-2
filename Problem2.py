# Time Complexity : O(nm) 
# Space Complexity : O(nm)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no


"""
Approach

when are start building the matrix we will fill the 0,0 0,1 ... 0,n with 0
then we start the loop with position 1,1 because if weight is 0  that mean no item and bagW is 0 meaning we can't put anything inside
so from there we start filling the matrix
we will have the same amount as the previous row until we reach the bagW value that can store the new item
when we are at the stage were are can pick the new item we apply
dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-w[i]]+ p[i])
here are check max value between the value that is right above the current value( dp[i-1][j] )
with value where we subtract the weight value from the above row plus the price to the current item value( dp[i-1][j-w[i]]+ p[i] )
in the end we will get the max value at the end of the matrix dp[w.length][bagW]

"""



def  knapsack(w:List[int], p:List[int], bagW: int) -> int:
    row = len(w) + 1
    col = bagW + 1

    dp = [[0 for _ in range(col)] for _ in range(row)]
    
    for i in range(1,row):
        for j in range(1,bagW):
            if j < w[i-1]:
                dp[i][j] = dp[i-1][j]
            else:
                dp[i][j] = max(dp[i-1][j], dp[i-1][j-w[i]]+ p[i])
    re = dp[len(w)][bagW]
    return re