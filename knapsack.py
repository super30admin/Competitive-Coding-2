val = [10,35,75,90]
wt = [10,20,30,50]
W=100
n = len(val)
def knapsack(W,wt,val,n):
    K = [[0 for x in range(W+1)]for x in range(n+1)]
    for i in range(n+1):
        for w in range(W+1):
            if i==0 or w==0:
                K[i][w]=0
            elif wt[i-1]<W:
                K[i][w] = max(val[i-1]+K[i-1][w-wt[i-1]],K[i-1][w])
            else:
                K[i][w] = K[i-1][w]
    print(K)
    return K[n][W]

print(knapsack(W,wt,val,n))
