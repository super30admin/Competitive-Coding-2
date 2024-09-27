# KnackSpace Problem

def knapSack(C, wt, val, n): 
    arr = [[0 for x in range(C + 1)] for x in range(n + 1)] 
  
    for i in range(n + 1): 
        for j in range(C + 1): 
            if i == 0 or j == 0: 
                arr[i][j] = 0 # Initializiing first row of tabel as 0
            elif wt[i-1] <= j: 
                arr[i][j] = max(val[i-1] 
                          + arr[i-1][j-wt[i-1]],   
                              arr[i-1][j]) 
            else: 
                arr[i][j] = arr[i-1][j] 
  
    return arr[n][C] 
  
  
# Driver code 
val = [60, 100, 120] 
wt = [10, 20, 30] 
W = 50
n = len(val) 
print(knapSack(W, wt, val, n)) 
