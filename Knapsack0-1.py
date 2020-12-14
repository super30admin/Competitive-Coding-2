# TC : O(N * W) ; N = no. of weight elements, W = capacity
# SC : O(N * W) ; 2D matrix to store the values
# Approach : We store the sub problem values in table so that we don't perform repetitive computation like in recursion,
# We fill 0 if i == 0 or w == 0. If current weight is more than current capacity, copy above row's col's value, else
# max of selecting current weight's value + remaining capacity's weight and previous row's col's value. Our answer
# lies in last row, last col.
 
def knapSack(W, wt, val, n): 
    K = [[0 for i in range(W + 1)] for i in range(n + 1)] 
  
    for i in range(n + 1): 
        for w in range(W + 1): 
            if i == 0 or w == 0: 
                K[i][w] = 0

            elif wt[i-1] <= w: 
                K[i][w] = max(val[i-1] 
                          + K[i-1][w-wt[i-1]],   
                              K[i-1][w]) 
            else: 
                K[i][w] = K[i-1][w] 
  
    return K[n][W] 
  
  
# Driver code 
val = [10, 15, 40] 
wt = [1, 2, 3] 
W = 6
n = len(val) 
print(knapSack(W, wt, val, n)) 