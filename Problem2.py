#knapsack problem
#time complexity:O(n*W)
#space complexity:O(n*W)

def knapsack(W,wt,val,n):
    
    k = [[0 for j in range(W+1)] for i in range(n+1)]


    for i in range(n+1):
        for j in range(W+1):

            if i ==0 or j ==0:
                k[i][j] = 0

            if wt[i-1] <= j:
                k[i][j] = max(k[i-1][j], val[i-1] + k[i-1][j-wt[i-1]])

            else:
                k[i][j] = k[i-1][j]

    return k[n][W]


val = [60, 100, 120]
wt = [10, 20, 30]
W = 50
n = len(val)
print(knapsack(W, wt, val, n))


