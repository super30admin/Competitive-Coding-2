#time complexity: O(capacity*W)
#Space complexity: O(capacity*W)
weights=[5,3,4,2]
values=[70,60,50,10]
capacity=7
dp=[[0 for i in range(capacity+1)] for j in range(len(weights)+1)]
for i in range(1,len(weights)+1):
    for j in range(1,capacity+1):
        if j < weights[i-1]:
            dp[i][j]=dp[i-1][j]
        else:
            dp[i][j]= max(dp[i-1][j], values[i-1]+dp[i-1][j-weights[i-1]])
print(dp[-1][-1])
