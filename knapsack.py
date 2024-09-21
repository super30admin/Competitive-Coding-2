# Input: N = 3, W = 4, profit[] = {1, 2, 3}, weight[] = {4, 5, 1}
# Output: 3
    
# Input: N = 3, W = 3, profit[] = {1, 2, 3}, weight[] = {4, 5, 6}
# Output: 0

def knapsack(i, w, val):
    # base
    if w < 0:
        return -1
    
    if i == N:
        return val
    
    case1 = knapsack(i+1, w-weight[i], val + profit[i])
    case2 = knapsack(i+1, w, val)
    return max(case1, case2)
    
N = 3
W = 4
profit = [1, 2, 3]
weight = [4, 5, 1]
print(knapsack(0, W, 0))

N = 3
W = 3
profit = [1, 2, 3]
weight = [4, 5, 6]
print(knapsack(0, W, 0))
    
    
    
