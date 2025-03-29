'''
The below dynamic programming solution has a  
TC = O(n * W) 

SC = O(n * W)

This approach is ideal because the knapsack problem has overlapping subproblems and involves two decisions 
at each step—whether to include an item or not.
'''

def knapsack(W, profit, wt):
    n = len(wt)
    dp = [[0 for _ in range(W+1)] for _ in range(n+1)]

    #Build the dp table
    for i in range(n+1):
        for j in range(W+1):
            #if the no. of elements is 0 or capacity is 0
            if i == 0 or j == 0:
                dp[i][j] = 0

            else:
                pick = 0

                pick = profit[i-1] + dp[i-1][j - wt[i-1]]

                notPick = dp[i-1][j]

                dp[i][j] = max(pick, notPick)

    return dp[n][W]

if __name__ == "__main__":
    profit = [30,60,90]
    wt = [10,20,30]
    W = 30

    print(knapsack(W,profit,wt))
