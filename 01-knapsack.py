# bu approach 

def ks(weights, values, cap):
    wlen = len(weights)
    if not wlen:
        return 0
    
    dp = [[0 for j in range(cap+1)] for i in range(wlen+1)]
    
    # starting with 1 elements
    for i in range(1, wlen+1):
        for j in range(cap+1):
            if weights[i - 1] > j:
                dp[i][j] = dp[i-1][j]
            else:
                dp[i][j] = max(values[i-1] + dp[i-1][j - weights[i-1]], dp[i-1][j])
    # print(dp)
    return dp[-1][-1]
    
#
# TC: O(n*m) - number of elements * capacity
# SC: O(n*m)
    
    


# td approach
# def rec(rc, idx, weights, values, dp):
#     # base
#     if idx >= len(weights):
#         return 0
#     if rc == 0:
#         return 0
    
#     if dp[rc][idx] != -1:
#         return dp[rc][idx]
    
#     # logic
#     case1, case2 = 0, 0
#     if weights[idx] <= rc:
#         case1 = values[idx] + rec(rc - weights[idx], idx + 1, weights, values, dp)
#     case2 = rec(rc, idx + 1, weights, values, dp)
    
#     dp[rc][idx] = max(case1, case2)
#     return dp[rc][idx]

# TC: O(m*n)
# SC: O(m*n)

weights = [10, 20, 30]
values = [60, 100, 120]

# capacity = 50
# dp = [[-1 for j in range(len(weights))] for i in range(capacity+1)]

# print(rec(capacity, 0, weights, values, dp))

# print(rec(70, 0, weights, values, dp))
# print(rec(30, 0, weights, values, dp))
# print(rec(10, 0, weights, values, dp))

print(ks(weights, values, 70))
print(ks(weights, values, 30))
print(ks(weights, values, 10))
print(ks(weights, values, 50))