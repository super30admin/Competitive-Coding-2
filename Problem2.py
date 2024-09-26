
#time complexity O(nC) n is no. of items and C is capacity
#space complexity:O(2*C)=>O(C)

# // Any problem you faced while coding this : no

def knapSack(Wcap, wt, val, n):
    dp=[[0 for _ in range(Wcap+1)] for x in range(n+1)]

#n(items)*capacity(Wcap) matrix
    for i in range (n+1):
        for j in range(Wcap+1):
            if i==0 or j==0:
                dp[i][j]=0
            #check if the weight is less than or equal to capacity    
            elif wt[i-1]<=Wcap:
                #max value from case 1 where the item is included and when it is not included 
                dp[i][j]=max(val[i-1]+dp[i-1][j-wt[i-1]],dp[i-1][j])
            else:
                #consider next item 
                dp[i][j]=dp[i-1][j]
    return dp[n][Wcap]



def main():
# Driver code
    val = [60, 100, 120]
    wt = [10, 20, 30]
    W = 50
    n = len(val)
    print(knapSack(W, wt, val, n))
main()    