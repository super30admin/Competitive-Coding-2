# Time Complexity : O(N*C)
# Space Complexity : O(N*C) 
# Any problem you faced while coding this : NO

def ks(wt,pr,C,n):
    T = [[0 for j in range(C+1)]for i in range(n+1)]
    
    for i in range(n+1):
        for j in range(C+1):
            if i==0 or j==0:
                T[i][j]=0
            elif wt[i-1]<=j:  #include
                T[i][j] = max(T[i-1][j], pr[i-1]+T[i-1][j-wt[i-1]])
            else:
                T[i][j] = T[i-1][j]
    return T[n][C]

val = [10, 15, 40]
wt = [1, 2, 3]
W = 4
n = len(val)
print(ks(wt, val, W, n))