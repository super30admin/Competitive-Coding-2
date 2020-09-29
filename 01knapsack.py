# TC : O(w*C), as we are building a 2d dp array, building values up from wt = 0 till wt=capacity, when having item type options as obj1, obj1+obj2 .., all objects   
#SC : O(w*C)
#did this run, need to test, this is just a vague idea
#Approach:
#build a dp array #objects x capacity wt, 4x5, since while filling, to avoid index error for the formula, we add 1 0's row, 1 0's columns, becomes 5x6
#Start with, with item 1, what is the best possible way to fill sack of wt = 1 till 5
#With item 1 and 2, what is the best possible way to fill sack of wt = 1 till 5
#hence if item wt>capacity just copy value from previous row
#else now there is a choice between max(dp[i-1][j], dp[i][j-weights[i]] + values[i])  

weights = [1,2,3,2]
values = [60,100,120,300]
capacity = 5

def getMaxValue():
    dp = [[0 for _ in range(capacity+1)] for _ in range(len(weights)+1)]
    
    for i in range(1,len(weights)+1):
        for j in range(capacity+1):
            if(weights[i]>j):
                dp[i][j] = dp[i-1][j]    
            else:
                dp[i][j] = max(dp[i-1][j], dp[i-1][j-weights[i]]+values[i])

    return dp[len(weights)][len(capacity)]                