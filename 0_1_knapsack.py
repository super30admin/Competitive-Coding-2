v = [1, 2, 6]
w = [2, 3, 5]
# w = [3, 4, 1]
cap = 8

# def solution(v, w, cap):
#     if cap == 0:
#         return 0
#     if len(v) == 0:
#         return 0

#     def helper(v, w, index, cap, profit):
#         # base
#         if index == len(v):
#             return profit
#         if cap - w[index] < 0:
#             return profit
#         case1 = helper(v, w, index+1, cap-w[index], profit+v[index])
#         case0 = helper(v, w, index+1, cap, profit)
#         return max(case0, case1)

#     return helper(v, w, 0, cap, 0)

# print(solution(v, w, cap))

def solution(v, w, cap):
    dp = [[0 for _ in range(cap + 1)] for _ in range(len(w)+1)]
    # base - selecting obj with 0 weight and 0 val
    # already taken care of by initiailising with 0s
    for i in range(1, len(dp)):
        for j in range(1, len(dp[0])):
            if w[i-1] <= j:
                dp[i][j] = max(v[i-1] + dp[i-1][j-w[i-1]], dp[i-1][j])
            else:
                dp[i][j] = dp[i-1][j]
    print(dp)
    return dp[-1][-1]

print(solution(v, w, cap))