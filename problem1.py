# DP question
#tc: O(m*n)
#sc: O(m*n)
weights = [10,20,30]
values = [60,100,120]
capacity = 50
dp = [[0]*(capacity+1) for i in range(len(weights)+1)]
for i in range(1,len(dp)):
    for j in range(1,len(dp[0])):
        # weight is more than Capacity
        if j < weights[i-1]:
            dp[i][j] = dp[i-1][j]
        else:
            dp[i][j] = max(dp[i-1][j],values[i-1] + dp[i-1][j - weights[i - 1]])
res = dp[len(dp)-1][len(dp[0])-1]
# print(dp)
if res != 0:
    print(res)
else:
    print(-1)