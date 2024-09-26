# Time Complexity - O(nW) where n is the length of w array and W is the value of weight limit
# Space Complexity - O(W)
def knapsack(w,v,W):
    prev = [0 for i in range(W+1)]
    curr = [None]*(W+1)
    i = 1
    j = 0
    while True:
        if j<w[i-1]:
            curr[j] = prev[j]
        else:
            curr[j] = max(prev[j], v[i-1]+prev[j-w[i-1]])
        j = j+1
        if j==len(prev):
            j = 0
            i = i+1
            if i==len(w)+1:
                break
            prev[:] = curr[:]
    return curr[-1]


'''   Time Complexity - O(nW), Space Complexity - O(nW)
def knapsack(w,v,W):
    dp = [[0 for j in range(W+1)] for i in range(len(w)+1)]
    for j in range(W+1):
        dp[0][j] = 0
    for i in range(1,len(w)+1):
        for j in range(W+1):
            if j<w[i-1]:
                dp[i][j] = dp[i-1][j]
            else:
                dp[i][j] = max(dp[i-1][j],v[i-1]+dp[i-1][j-w[i-1]])
    return dp[-1][-1]'''


'''  Brute Force approach
def knapsack(w,v,W):
    if len(w)==0:
        return -1
    return helper(w,v,W,0,0)

def helper(w,v,W,index,value):
    # base
    if W==0:
        return value
    if W<0 or index==len(w):
        return -1
    # logic
    case1 = helper(w,v,W,index+1,value)
    case2 = helper(w,v,W-w[index],index+1,value+v[index])
    return max(case1,case2)'''
