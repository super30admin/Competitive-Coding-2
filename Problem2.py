class Solution:
    def KnapSack(capacity,weight,profit):
        # TC: O(length of weights * capacity)
        # SC: O(length of weights * capacity)
        # Utilised 2D array as we have 2 parameters capacity and profit 
        n = len(weight)
        dp = [[0 for _ in range(capacity + 1)] for _ in range(n + 1)]

    
        for i in range(n + 1):
            for w in range(capacity + 1):
                if i == 0 or w == 0:
                    dp[i][w] = 0
                elif weight[i - 1] <= w:
                    dp[i][w] = max(profit[i - 1] + dp[i - 1][w - weight[i - 1]], dp[i - 1][w])
                else:
                    dp[i][w] = dp[i - 1][w]
        return dp[n][capacity]
    profit = [60,100,120]
    weight = [10,20,30]
    capacity = 50
    print(KnapSack(capacity,weight,profit))

