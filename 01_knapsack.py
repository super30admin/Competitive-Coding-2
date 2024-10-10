def main():
    profit = [60, 100, 120]
    weight = [10, 20, 30]
    capacity = 50
    print(helper(profit, weight, capacity, 0, 0))

    def helper(profit, weight, capacity, index, current_profit):
        # Base case
        if index >= len(weight):
            return current_profit

        # Case where the item is not picked
        case0 = helper(profit, weight, capacity, index + 1, current_profit)

        # Case where the item is picked
        case1 = current_profit
        if weight[index] <= capacity:
            case1 = helper(
                profit,
                weight,
                capacity - weight[index],
                index + 1,
                current_profit + profit[index],
            )

        return max(case0, case1)

    # dp method

    m = len(weight)
    n = capacity
    dp = [[0 for _ in range(n + 1)] for _ in range(m + 1)]
    for i in range(m + 1):
        for j in range(n + 1):
            if j < weight[i - 1]:
                dp[i][j] = dp[i - 1][j]
            else:
                dp[i][j] = max(
                    dp[i - 1][j], dp[i - 1][j - weight[i - 1]] + profit[i - 1]
                )
    print(dp[m][n])
    return dp[m][n]


if __name__ == "__main__":
    main()

# time complexity is O(m*n)
# space complexity is O(m*n)
