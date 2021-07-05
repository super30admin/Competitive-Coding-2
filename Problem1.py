#0/1 knapsack
#Time Complexity: O(N*W).
#Auxiliary Space: O(N*W)
#Did this code successfully run on GeeksforGeeks :Yes

def knapSack(W, wt, val, n):
    dp = [[0 for ind in range(0,W+1)] for i in range(0,len(wt)+1)]
    for top_ind in range(1,n+1):
        weight = wt[top_ind-1]
        value = val[top_ind-1]
        for index in range(1,W+1):
            if index < weight:
                dp[top_ind][index] = dp[top_ind-1][index]
            else:
                dp[top_ind][index] = max(dp[top_ind-1][index],value+dp[top_ind-1][index-weight])

    return dp[n][W]




W = 65
wt =[2,60,74,55,74,10,26,65,60,15,82,40,22,30,62,99,48,76,72,45,55,53,67,28,78,11,60,4,36,33,4,70,34,47,35,5,22,53,28,65,9,9,78,41,65,5]
val= [42,70,11,89,89,69,11,46,64,75,70,33,91,13,46,12,100,25,19,35,76,67,70,30,55,76,58,16,75,63,27,47,64,10,38,79,30,46,10,40,1,95,33,60,80,78]



print(knapSack(W,wt, val, len(wt)))