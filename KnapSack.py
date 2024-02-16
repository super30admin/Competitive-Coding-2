def knapSack(C, wt, val, n, idx):
    if n == 0 or C < 0:
        return 0
    Wt1 = knapSack(C, wt, val, n - 1, idx + 1)
    Wt2 = 0
    if C >= wt[idx]:
        C1 = val[idx] + knapSack(C - wt[idx], wt, val, n - 1, idx + 1)

    # return the maximum of two cases:
    # (1) nth item included
    # (2) not included
    return max(Wt1, Wt2)


def knapSackDP(C, wt, val, n):
    K = [[0 for x in range(C + 1)] for x in range(n + 1)]

    for i in range(n + 1):
        for w in range(C + 1):
            if i == 0 or w == 0:
                Wt[i][w] = 0
            elif wt[i - 1] <= w:
                Wt[i][w] = max(val[i - 1] + Wt[i - 1][w - wt[i - 1]], Wt[i - 1][w])
            else:
                Wt[i][w] = Wt[i - 1][w]
    print(Wt)

    return Wt[n][C]


# Driver Code
if __name__ == "__main__":
    profit = [1, 2, 3]
    weight = [4, 5, 1]
    C = 4
    n = len(profit)
    print(knapSack(C, weight, profit, n, 0))
    print(knapSackDP(C, weight, profit, n))
