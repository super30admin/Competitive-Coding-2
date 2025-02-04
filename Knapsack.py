# TIme: O(n^2)
# Space: O(n)
# driver
def findMaxProfit(profit: [int], weight: [int], w: int):
    return getMax(profit, weight, w, 0)
    

# helper
def getMax(profit: [int], weight: [int], w: int, index: int): 
    
    if w < 0:
        return -profit[index-1]
    if w == 0:
        return 0
    if index >= len(weight): return 0
    
    # choose
    opt_1 = profit[index] + getMax(profit, weight, w-weight[index], index+1)
    # not choose
    opt_2 = getMax(profit, weight, w, index+1)
    return max(opt_1, opt_2)

# Time: O(n*m)
# Space: O(m*n)
# driver
def findMaxProfitDP(profit: [int], weight: [int], w: int):
    dp = [[0] * (w+1) for i in range(len(weight)+1)]
    
    for i in range(1, len(weight)+1):
        for j in range(1, w+1):
            if j < weight[i-1]:
                dp[i][j] = dp[i-1][j]
            else:
                dp[i][j] = max(dp[i-1][j], profit[i-1]+dp[i-1][j-weight[i-1]])
    return dp[-1][-1]

profit = [60, 100, 120]
weight = [10, 20, 30]
w = 50
print(findMaxProfitDP(profit, weight, w))