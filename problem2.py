#time complexity: O(N * W)
#Auxiliary Space: O(N * W) + O(N)


class Solution:
    def knapsackproblem(self, wt, val, W, n):
        # Initialize memoization table
        t = [[-1 for _ in range(W + 1)] for _ in range(n + 1)]

        # Base condition: if weight is zero or number of items is zero
        if n == 0 or W == 0:
            return 0

        # if the value is already computed
        if t[n][W] != -1:
            return t[n][W]

        # if the current item's weight is less than or equal to the remaining capacity
        if wt[n - 1] <= W:
            t[n][W] = max(
                val[n - 1] + self.knapsackproblem(wt, val, W - wt[n - 1], n - 1),
                self.knapsackproblem(wt, val, W, n - 1)
            )
            return t[n][W]
        else:
            # If the current item's weight is more than the remaining capacity
            t[n][W] = self.knapsackproblem(wt, val, W, n - 1)
            return t[n][W]


sol = Solution()
wt = [10, 20, 30] 
val = [60, 100, 120] 
W = 50
n = len(val)
result = sol.knapsackproblem(wt, val, W, n)
print(result)