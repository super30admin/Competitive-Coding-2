# Knapsack Problem

# Time Complexity - O(nW) where n is the length of w array and W is the value of weight limit
# Space Complexity - O(W)

def knapsack(w,v,W):
    prev = [0 for i in range(W+1)]
    curr = [None]*(W+1)
    i = 1
    j = 0
    while True:
        if j<w[i-1]:
            curr[j] = prev[j]
        else:
            curr[j] = max(prev[j], v[i-1]+prev[j-w[i-1]])
        j = j+1
        if j==len(prev):
            j = 0
            i = i+1
            if i==len(w)+1:
                break
            prev[:] = curr[:]
    return curr[-1]
