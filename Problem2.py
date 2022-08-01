# Time complexity : O(n*m) n --> number of weights, m --> max weight
# Space complexity : O(n*m) n --> number of weights, m --> max weight

def maxProfit(weights, profit, max_weight):
  
    # finding rows and columns
    rows = len(weights)
    columns = max_weight
    
    # if no weights then return 0
    if rows == 0:
        return 0
    # creating a 2-d matrix
    dp = [[0 for _ in range(columns+1)] for _ in range(rows+1)]
    
    # traversing through the matrix for rows and columns from the 2nd row 2nd columns, as rest all are 0
    for i in range(1,rows+1):
        for j in range(1,columns+1):
            # if the column which is the weight at that column is less than the weights I have at this point is less, then I copy the max profit from above
            if j < weights[i-1]:
                dp[i][j] = dp[i-1][j]
            else:
              # else, I add the profit value with the max value from above, but with the gap of weight size, as I can use the weight only once, or the 
              # value from just above whichever one is the max value
                dp[i][j] = max(profit[i-1] + dp[i-1][j-weights[i-1]],dp[i-1][j])
    # returing the final answer at the last row and column value in the matrix
    return dp[rows][columns]
    
    
weights = [1,2,3]
profit = [60,100,120]
max_weight = 5

res = maxProfit(weights, profit, max_weight)
