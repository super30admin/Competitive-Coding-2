class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        length = len(prices)
        profit = 0
        mini = 99999
        for i in range(0, length):
            if prices[i] < mini:
                mini = prices[i]
            else:
                current_profit = prices[i] - mini
                if profit < current_profit:
                    profit = current_profit
        return profit