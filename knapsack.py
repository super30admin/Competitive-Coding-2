#TC = O(n*m)
#SC = O(n*m)
#Compiled and run on LC

def maxprofit(val,wt,cap):
    n = len(val) + 1
    m = len(wt) + 1

    matrix = [[0 for i in range(c+1) for j in range(m)]]

    for i in range(1,m):
        for j in range(1,cap+1):
            if(j < wt[i-1]):
                matrix[i][j] = matrix[i-1][j]
            else:
                matrix[i][j] = max(val[i-1]+matrix[i-1][j-wt[i-1]], matrix[i-1][j])

    return matrix[m-1][cap]

print(maxprofit([6,10,12],[1,2,3],5))