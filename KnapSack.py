#Time Complexity: O(N*M) where N is the capacity and M is the weights
# Space Complexity :0(N*M) Wwhere N is the capacity and M is the weights
def knapSack(W, wt, val):
    dp = [[0 for x in range(W+1)] for y in range(len(wt)+1)]

    for i in range(1,len(dp)):
        for j in range(len(dp[0])):
            if j < wt[i-1]:
                dp[i][j] = dp[i-1][j]
            elif j>=wt[i-1]:
                dp[i][j] = dp[i-1][j-wt[i-1]]+val[i-1]
    return (dp[len(dp)-1][len(dp[0])-1])

val = [60, 100, 120] 
wt = [10, 20, 30] 
W = 50 
k = knapSack(W, wt, val)
print(k) 

val = [1, 2, 3] 
wt = [4, 5, 6] 
W = 8
k = knapSack(W, wt, val)
print(k) 

val = [1, 2, 3] 
wt = [4, 5, 1] 
W = 8
k = knapSack(W, wt, val)
print(k) 


#Answers for ll three test case is :
#1) 220
#2) 3
#3) 5