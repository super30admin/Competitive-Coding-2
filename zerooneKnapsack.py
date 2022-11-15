def helper(ele, val, dp):
    for i in range(1,len(dp)):
        for j in range(1,len(dp[0])):
            if j>=ele[i-1]:
                dp[i][j] = max(val[i-1]+ dp[i-1][j-ele[i-1]], dp[i-1][j])
            else:
                dp[i][j] = dp[i-1][j]
    
    print(dp[-1][-1])



ele = [1,2,3]
val = [60, 100, 120]
w = 5

dp = [[0 for i in range(w+1)] for j in range(len(ele)+1)]   # this is to make 2d array fill wih 0 values
helper(ele, val, dp)



