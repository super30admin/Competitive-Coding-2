"""
Recursive exhastive approach
TC - O(N)
SC - O(N)
"""
def ks(weight,val,maxWeight,index,maxValue,curWeight):
    pick = 0
    if index >= len(weight):
        return maxValue
    nothing = ks(weight,val,maxWeight,index+1,maxValue,curWeight)
    if weight[index]+curWeight <= maxWeight:
        pick = ks(weight,val,maxWeight,index+1,val[index]+maxValue,weight[index]+curWeight)
    if nothing >= pick:
        return nothing
    else:
        return pick


"""
Recursive exhastive approach
TC - O(nxm)
SC - O(1)
"""
def ks2(weight,val,maxWeight):
    dp = [[0 for i in range(maxWeight + 1)] for j in range(len(val) + 1)]
    for i in range(len(val)):
        for j in range(1,maxWeight+1):
            if j < weight[i]:
                dp[i][j] = dp[i-1][j]
            else:
                if val[i] + dp[i-1][j - weight[i]] >= dp[i-1][j]:
                    dp[i][j] = val[i] + dp[i-1][j - weight[i]]
                else:
                    dp[i][j] = dp[i-1][j]
    return dp[len(val) - 1][maxWeight]

weight = [1,2,3]
val = [10,15,40]
print(ks2(weight,val,6))