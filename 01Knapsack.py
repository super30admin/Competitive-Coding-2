class Solution:
    def knapsack(self, W, val, wt):
        self.memo = {}
        return self.helper(val, wt, W, 0)

    def helper(self, profitList, weight, capacity: int, idx: int) -> int:
        # Base case
        if idx == len(weight) or capacity == 0:
            return 0

        # Memoization check
        if (idx, capacity) in self.memo:
            return self.memo[(idx, capacity)]

        # Option 1: skip current item
        profit1 = self.helper(profitList, weight, capacity, idx + 1)

        # Option 2: take current item (if it fits)
        profit2 = 0
        if weight[idx] <= capacity:
            profit2 = profitList[idx] + self.helper(profitList, weight, capacity - weight[idx], idx + 1)

        # Store best result in memo
        self.memo[(idx, capacity)] = max(profit1, profit2)

        return self.memo[(idx, capacity)]


    