#Problem 2: 0/1 KNAPSACK PROBLEM
# TIME COMPELXITY:O(M*N) where M denotes the number of items and N is the maximum capacity
# SPACE COMPLEXITY: In Approach 1 it is O(M*N) and then on optimization it goes to O(N)
# where N is the maximum capacity

def findMaxValue(W, val, wt):

    #Approach 1
    #In this approach you are making a tabular matrix which is referencing the prev row and val
    # if the weight is less than the current j else it is just taking the value that the row before it
    # has followed by seeing which has the max value as that is what being required as the answer
    # n=len(wt)
    # dp=[[0]*(W+1)for _ in range(n+1)]
    # for i in range(n+1):
    #     for j in range(W+1):
    #         if i==0 or j==0:
    #             dp[i][j]=0
    #         else:
    #             considered=0
    #             if wt[i-1]<=j:
    #                 considered=val[i-1]+dp[i-1][j-wt[i-1]]

    #             notConsidered=dp[i-1][j]
    #             dp[i][j]=max(considered,notConsidered)
    # return dp[n][W]

    #Approach 2
    #Doing similar to approach 1 just making all the updates in the same location rather than doing references of like
    # prev row
    dp=[0]*(W+1)
    for i in range(1,len(wt)+1):
        for j in range(W,wt[i-1]-1,-1):
            considered=val[i-1]+dp[j-wt[i-1]]
            notConsidered=dp[j]
            dp[j]=max(considered,notConsidered)
    return dp[W]

