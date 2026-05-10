def knapsack(W, val, wt):
    n = len(wt)
    dp = [[0 for _ in range(W + 1)] for _ in range(n + 1)]

    for i in range(n + 1):
        for j in range(W + 1):

            # If there are no items or capacity is 0
            if i == 0 or j == 0:
                dp[i][j] = 0
            else:
                choose = 0

                # Choice 1: choose the current item
                if wt[i - 1] <= j:
                    choose = val[i - 1] + dp[i - 1][j - wt[i - 1]]

                # Choice 2: don't choose the current item
                dont_choose = dp[i - 1][j]

                dp[i][j] = max(choose, dont_choose)

    return dp[n][W]


# Time complexity: O(n * W), where n is the number of items and W is the knapsack capacity.
# We fill a DP table of size (n + 1) * (W + 1), and each cell takes O(1) time.

# Space complexity: O(n * W), because we store a 2D DP table with
# (n + 1) rows and (W + 1) columns.