#Time complexity: O(n)
#Space complexity: O(m*n) where n is number of items and m is the maximum weight allowed

#Approach:
#Use dynamic programming similar to coin change problem
#Construct an m*n matrix where at each index [i][j] you take pick the current value, or don't pick it



# def knapsackRecursive(W, V, i, curWeight):
#     if i < 0 or curWeight <= 0:
#         return 0

#     return max(knapsack(W, V, i-1, curWeight - W[i]) + V[i], knapsack(W, V, i-1, curWeight))


def knapsack(W,V,weight):
    n = len(V)
    m = weight
    dp = [[0 for j in range(m+1)] for i in range(n+1)]

    for i in range(1, n+1):
        for j in range(1, m+1):
            case1 = dp[i-1][j]
            case2 = 0 if j < W[i-1] else dp[i-1][j-W[i-1]] + V[i-1]
            dp[i][j] = max(case1,case2)

    return dp[n][m]



def main():
    V = [60, 100, 120]
    W = [10, 20, 30]
    curWeight = 50
    print(knapsack(W,V,curWeight))

main()