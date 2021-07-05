# Time Complexity : O(N * C) C is the capacity
# Space Complexity : O(N * C)

def knapSack(W, wt, val, n):
    K = [[0 for x in range(W + 1)] for x in range(n + 1)]
    for i in range(n + 1):
        for w in range(W + 1):
            # least index or weight is 0
            if i == 0 or w == 0:
                K[i][w] = 0
            # max of current value or the sum of previous values
            elif wt[i-1] <= w:
                K[i][w] = max(val[i-1]
                          + K[i-1][w-wt[i-1]],
                              K[i-1][w])
            else:
                K[i][w] = K[i-1][w]
    return K[n][W]
val = [60, 100, 120]
wt = [1, 2, 3]
W = 5
print(knapSack(W, wt, val, len(val)))