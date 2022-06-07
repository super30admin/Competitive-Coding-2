#time complexity is o(mn), where m is the size of the input weights and n is the given capacity
#space complexity is o(mn), where m is the size of the input weights and n is the given capacity
w = [10, 20, 30]
v = [60, 100, 120]
c = 50

def maxcap(w, v, c):
    m = len(w)
    n = 50
    dp = [[0 for i in range(n+1)] for i in range(m+1)]
    for i in range(1, m+1):
        for j in range(n+1):
            # print(i,j)
            if(j < w[i-1]):
                dp[i][j] = dp[i-1][j]
            else:
                dp[i][j] = max(dp[i-1][j], dp[i-1][j-(w[i-1])] + v[i-1])
    return(dp[m][n])
print(maxcap(w,v,c))


