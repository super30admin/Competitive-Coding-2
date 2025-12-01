class Solution:
    """
    ------------------------------------------------------------
    0/1 Knapsack Problem
    ------------------------------------------------------------
    We are given:
      - val[i] : value of the i-th item
      - wt[i]  : weight of the i-th item
      - W      : total capacity of knapsack

    Goal:
      Pick items such that:
        - total weight ≤ W
        - total value is maximized
        - each item can be picked 0 or 1 time (0/1 property)
    
    Approaches:
      1. Recursion (Brute Force) : O(2^n)
      2. Recursion + Memoization : O(n*W)
      3. Bottom-Up DP (2D) : O(n*W) Space O(n*W)
      4. Bottom-Up DP (Optimized 1D) : O(n*W) Space O(W)  ← Optimal
    ------------------------------------------------------------
    """

    def knapsack(self, val, wt, W):
        n = len(val)

        """
        ============================================================
        1. RECURSION (Brute Force) : Exponential Time

        def solve_rec(i, W):
            if i == 0:
                return val[0] if wt[0] <= W else 0

            not_take = solve_rec(i - 1, W)

            take = 0
            if wt[i] <= W:
                take = val[i] + solve_rec(i - 1, W - wt[i])

            return max(take, not_take)
        ============================================================
        """


        """
        ============================================================
        2. RECURSION + MEMOIZATION : Top-Down DP

        dp = [[-1] * (W + 1) for _ in range(n)]

        def solve_memo(i, W):
            if i == 0:
                return val[0] if wt[0] <= W else 0

            if dp[i][W] != -1:
                return dp[i][W]

            not_take = solve_memo(i - 1, W)
            take = 0
            if wt[i] <= W:
                take = val[i] + solve_memo(i - 1, W - wt[i])

            dp[i][W] = max(take, not_take)
            return dp[i][W]
        ============================================================
        """


        """
        ============================================================
        3. BOTTOM-UP DP (2D Array)

        dp = [[0] * (W + 1) for _ in range(n)]

        for w in range(wt[0], W + 1):
            dp[0][w] = val[0]

        for i in range(1, n):
            for w in range(W + 1):
                not_take = dp[i - 1][w]
                take = 0
                if wt[i] <= w:
                    take = val[i] + dp[i - 1][w - wt[i]]
                dp[i][w] = max(take, not_take)

        return dp[n - 1][W]
        ============================================================
        """


        """
        ============================================================
        4. BOTTOM-UP DP (Optimized 1D Array)  ✅ Optimal Solution
           - Only need previous row → compress to 1D
           - Iterate weights backwards to avoid overwriting
           - Time:  O(n * W)
           - Space: O(W)
        ============================================================
        """

        dp = [0] * (W + 1)

        # Initialize using the first item
        for w in range(wt[0], W + 1):
            dp[w] = val[0]

        # Process remaining items
        for i in range(1, n):
            for w in range(W, wt[i] - 1, -1):
                dp[w] = max(dp[w], val[i] + dp[w - wt[i]])

        return dp[W]
