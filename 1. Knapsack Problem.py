# Time Complexity - O(n*W) to fill the matrix
# Space Complexity - O(n*W) for the matrix itself

def knapSack(W, wt, val, n):
    matrix = [[0 for x in range(W+1)] for x in range(n+1)]

    for i in range(n+1):
        for j in range(W+1):
            # Initialize the matrix
            if i == 0 or j == 0:
                matrix[i][j] = 0

            elif wt[i-1] <= j:
                matrix[i][j] = max(val[i-1] + matrix[i-1][j-wt[i-1]], matrix[i-1][j])

            else:
               matrix[i][j] = matrix[i-1][j]

    return matrix[n][W]

val = [60, 100, 120]
wt = [10, 20, 50]
W = 60
n = len(val)
print(knapSack(W, wt, val, n))