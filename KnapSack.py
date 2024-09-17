
# Time Complexity - O(n*w) 
# Space Complexity - O(n*w) 

def knapSack(w, wt, value, n):
    mat = [[0 for x in range(w+1)] for x in range(n+1)]

    for i in range(n+1):
        for j in range(w+1):
    
            if i == 0 or j == 0:
                mat[i][j] = 0

            elif wt[i-1] <= j:
                mat[i][j] = max(value[i-1] + mat[i-1][j-wt[i-1]], mat[i-1][j])

            else:
               mat[i][j] = mat[i-1][j]

    return mat[n][w]

value = [40, 120, 70]
wt = [10, 30, 20]
w = 60
n = len(value)
print(knapSack(w, wt, value, n))