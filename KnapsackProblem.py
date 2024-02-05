def knapSack(C, wt, val, n, idx):
    # Base Case
    if n == 0 or C < 0:
        return 0
    # If weight of the nth item is
    # more than Knapsack of capacity W,
    # then this item cannot be included
    # in the optimal solution
    C1 = 0
    if C >= wt[idx]:
        C1 = val[idx] + knapSack(C - wt[idx], wt, val, n - 1, idx + 1)
    C2 = knapSack(C, wt, val, n - 1, idx + 1)

    # return the maximum of two cases:
    # (1) nth item included
    # (2) not included
    return max(C1, C2)


def knapSackDP(C, wt, val, n):
    K = [[0 for x in range(C + 1)] for x in range(n + 1)]

    for i in range(n + 1):
        for w in range(C + 1):
            if i == 0 or w == 0:
                K[i][w] = 0
            elif wt[i-1] <= w:
                K[i][w] = max(val[i-1]
                              + K[i-1][w-wt[i-1]],
                              K[i-1][w])
            else:
                K[i][w] = K[i-1][w]
    print(K)

    return K[n][C]

# end of function knapSack


# Driver Code
if __name__ == '__main__':
    profit = [1, 2, 3]
    weight = [4, 5, 1]
    C = 4
    n = len(profit)
    print(knapSack(C, weight, profit, n, 0))
    print(knapSackDP(C, weight, profit, n))
