# Approach: Use dynamic programming to solve the 0/1 Knapsack problem
# Create a 2D DP table where dp[i][j] represents the maximum value
# achievable with 'i' items and a knapsack capacity of 'j'
# For each item, we decide whether to include it or exclude it
# TC: O(n * W), SC: O(n * W) where n is the number of items and W is the capacity


class Solution:
    def knapsack(self, W, val, wt):
        n = len(val)  # Number of items

        # Create DP table: dp[i][j] -> max value with 'i' items and capacity 'j'
        dp = [[0] * (W + 1) for _ in range(n + 1)]

        # Fill DP table
        for i in range(1, n + 1):
            for j in range(1, W + 1):
                if wt[i - 1] > j:  # If item is too heavy, exclude it
                    dp[i][j] = dp[i - 1][j]
                else:
                    # Max of excluding or including the item
                    dp[i][j] = max(dp[i - 1][j], val[i - 1] + dp[i - 1][j - wt[i - 1]])

        return dp[n][W]  # Max value possible with given weight limit


# Example usage
sol = Solution()
W = 50
val = [60, 100, 120]
wt = [10, 20, 30]
print(sol.knapsack(W, val, wt))  # Expected Output: 220


# class Solution:
#     def knapsack(self, W, val, wt):
#         n = len(val)  # Number of items

#         def helper(i, capacity):
#             if i >= n:  # Base case: No more items left
#                 return 0

#             # Case 1: Skip the current item
#             case0 = helper(i + 1, capacity)

#             # Case 2: Take the current item (if possible)
#             case1 = 0
#             if wt[i] <= capacity:
#                 case1 = val[i] + helper(i + 1, capacity - wt[i])

#             return max(case0, case1)

#         return helper(0, W)  # Start recursion from index 0 and full capacity

# # Example usage
# sol = Solution()
# W = 50
# val = [60, 100, 120]
# wt = [10, 20, 30]
# print(sol.knapsack(W, val, wt))  # Expected Output: 220
