# weight=[10,20,30]
# profit=[60,100,120]
# C= 50
def knanpsack (self,weight, C, profit):
    row= len(weight)+1
    col = C +1
    
    dp = [[0 for x in range (col)] for x in range (row)]
    
    for i in range (col):
        dp[0][i] = 0 #initialize the first row with 0 weight
    
    for i in range (1, row):
        for j in range (1, col):
            if j< weight[i-1]:
                dp[i][j]= dp[i-1][j]
            else:
                dp[i][j] = (profit[i-1]+ dp[i][j-weight[i-1]])
    
    return dp[row-1][col-1]
