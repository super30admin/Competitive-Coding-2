# 0/1 Knapsack Problem
# Time Complexity: O(n^2)
# Space Complexity: O(n)
N = 3
W = 3
profit = [1, 2, 3]
weight = [4,5,1]

hmap = {}
res = 0

for i in range(N):
    for j in range(i+1, N):
        if weight[j] <= W:
            if weight[j] not in hmap:
                hmap[weight[j]] = profit[i]
                res = res + profit[j]
            else:
                hmap[weight[j]] = max(hmap[weight[j]], profit[j])
            res = max(res, hmap[weight[j]])
            W = W - weight[j]

print(res)
