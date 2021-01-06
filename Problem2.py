class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        if len(prices) <= 1: return 0
        current_profit = 0
        profit = 0
        buying = prices[0]
        for i in range(1, len(prices)):
            if prices[i] > buying and prices[i] - buying > current_profit:
                current_profit = prices[i] - buying
            else:
                profit += current_profit
                current_profit = 0
                buying = prices[i]
        profit += current_profit
        return profit