# Time Complexity: O(n * W)
# Space Complexity: O(n * W)
# Were you able to run the code on Leetcode: No
# Any problem you faced while coding this: The transformation of the problem into a 2D array and understanding the logic of filling it up

class Solution:
    def knapsack(self, W, wt, val, n):
        
        dp = [[0 for _ in range(W + 1)] for _ in range(n + 1)]

        # Build the dp array
        for i in range(1, n + 1):
            for w in range(1, W + 1):
                # If the weight of the current item is less than or equal to the current capacity w
                # we have two choices: include it or exclude it
                # If we include it, we add its value to the maximum value of the remaining capacity
                # If we exclude it, we take the maximum value without this item
                if wt[i - 1] <= w:
                    dp[i][w] = max(dp[i - 1][w], dp[i - 1][w - wt[i - 1]] + val[i - 1])
                else:
                    dp[i][w] = dp[i - 1][w]

        return dp[n][W]  # The maximum value is found at the bottom-right corner of the matrix
        

# Example usage:
if __name__ == "__main__":
    W = 50
    wt = [10, 20, 30]
    val = [60, 100, 120]
    n = len(val)
    
    solution = Solution()
    max_value = solution.knapsack(W, wt, val, n)
    print("Maximum value in Knapsack =", max_value)  # Output: Maximum value in Knapsack = 220
    
    val = [1, 2, 3]
    wt = [4, 5, 1]
    W = 4
    n = len(val)
    max_value = solution.knapsack(W, wt, val, n)
    print("Maximum value in Knapsack =", max_value)  # Output: Maximum value in Knapsack = 3
    