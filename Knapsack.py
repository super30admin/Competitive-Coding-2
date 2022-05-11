#Time Complexity O(WN) 
#Space Complexity O(2^W) 
#It successfully runs 

def knapSackRecursive(cap,wt,val):
    return knapSackhelper(cap,wt,val,0)
    
def knapSackhelper(cap,wt,val,index, profit):
    if cap < 0: return profit - val[index-1]
    if index >= len(val): return profit
    if cap == 0: return 
    #case1 Choose
    case1 = knapSackhelper(cap-wt[index],wt,val,index+1,profit+(val[index]))
    #case2 Not Choose
    case2 = knapSackhelper(cap,wt,val,index+1,profit)
    if case1 < 0: return case2
    if case2 < 0: return case1
    return max(case1,case2)

#Time Complexity O(WN) 
#Space Complexity O(WN) 
#It successfully runs
def knapSackdp2D(cap, wt, val):
    dp = [[0] * (cap+1)for i in range(len(val)+1)]
    for i in range(len(dp)):
        for j in range(len(dp[0])):
            if wt[i-1] <= j:
                dp[i][j] = max(dp[i-1][j],dp[i-1][j-wt[i-1]]+val[i-1])
            else:
                dp[i][j] = dp[i-1][j]
    return dp[-1][-1]

#Time Complexity O(WN) 
#Space Complexity O(W) 
#It successfully runs
def knapSackdp1D(cap, wt, val):
    dp = [0 for i in range(cap+1)]
    for i in range(1,len(val)+1):
        for w in reversed(range(cap+1)):
            if wt[i-1] <= w:
                dp[w] = max(dp[w],dp[w-wt[i-1]]+val[i-1])
    return dp[-1]



val = [6, 10, 12]
wt = [1, 2, 3]
cap = 5
print(knapSackRecursive(cap, wt, val))
print(knapSackdp2D(cap, wt, val))
print(knapSackdp1D(cap, wt, val))
