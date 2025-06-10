# Time Complexity : O(n * W), where n = number of items, W = capacity
# Space Complexity : O(W), due to space optimized 1D DP array
# Did this code successfully run on GFG : YES
# Any problem you faced while coding this : No

from typing import List

class Solution:

    def knapsack(self, W: int, profit: List[int], weight: List[int]) -> int:
        n = len(profit)

        # -----------------------------------------
        # Space Optimized Tabulation (1D DP)
        # Time Complexity: O(n * W)
        # Space Complexity: O(W)
        # -----------------------------------------
        dp = [0] * (W + 1)

        for i in range(n - 1, -1, -1):
            new_dp = dp[:]
            for w in range(W + 1):
                if weight[i] <= w:
                    new_dp[w] = max(dp[w], profit[i] + dp[w - weight[i]])
            dp = new_dp
        
        return dp[W]
    

        # -----------------------------------------
        # Tabulation (2D DP)
        # Time Complexity: O(n * W)
        # Space Complexity: O(n * W)
        # -----------------------------------------
        # dp = [[0] * (W + 1) for _ in range(n + 1)]

        # for i in range(n - 1, -1, -1):
        #     for w in range(W + 1):
        #         if weight[i] <= w:
        #             dp[i][w] = max(dp[i + 1][w], profit[i] + dp[i + 1][w - weight[i]])
        #         else:
        #             dp[i][w] = dp[i + 1][w]

        # return dp[0][W]


        # -----------------------------------------
        # Memoization (Top-down DP)
        # Time Complexity: O(n * W)
        # Space Complexity: O(n * W) for memo table + O(n) recursion stack
        # -----------------------------------------
        # memo = [[-1] * (W + 1) for _ in range(n)]

        # def helper(idx, remaining):
        #     if idx == n or remaining == 0:
        #         return 0
        #     if memo[idx][remaining] != -1:
        #         return memo[idx][remaining]
        #     if weight[idx] > remaining:
        #         memo[idx][remaining] = helper(idx + 1, remaining)
        #     else:
        #         include = profit[idx] + helper(idx + 1, remaining - weight[idx])
        #         exclude = helper(idx + 1, remaining)
        #         memo[idx][remaining] = max(include, exclude)
        #     return memo[idx][remaining]

        # return helper(0, W)


        # -----------------------------------------
        # Recursive (Brute-force)
        # Time Complexity: O(2^n)
        # Space Complexity: O(n) recursion stack
        # -----------------------------------------
        # def helper(idx, remaining):
        #     if idx == n or remaining == 0:
        #         return 0
        #     if weight[idx] > remaining:
        #         return helper(idx + 1, remaining)
        #     include = profit[idx] + helper(idx + 1, remaining - weight[idx])
        #     exclude = helper(idx + 1, remaining)
        #     return max(include, exclude)

        # return helper(0, W)


if __name__ == "__main__":
    sol = Solution()

    print(sol.knapsack(4, [1, 2, 3], [4, 5, 1]))  # Expected: 3
    print(sol.knapsack(50, [60, 100, 120], [10, 20, 30]))  # Expected: 220
    print(sol.knapsack(3, [10, 20, 30], [1, 1, 1]))  # Expected: 60
    print(sol.knapsack(0, [10, 20], [1, 2]))  # Expected: 0
    print(sol.knapsack(5, [1, 2, 3, 8, 7], [1, 2, 3, 4, 5]))  # Expected: 8
