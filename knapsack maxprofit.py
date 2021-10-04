#TC: O(m*n)
#SC: O(m*n)

def maxprofit(v,w,c):
    #n = len(v)+1
    m = len(w)+1
    mtx = [[0 for i in range(c+1)] for j in range(m)]
    for i in range(1,m):
        for j in range(1,c+1):
            if j < w[i-1]:
                mtx[i][j] = mtx[i-1][j]
            else:
                mtx[i][j] = max(v[i-1]+ mtx[i-1][j-w[i-1]], mtx[i-1][j])
    
    return mtx[m-1][c]


print(maxprofit([6,10,12],[1,2,3],5))