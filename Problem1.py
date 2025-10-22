
# def dp(idx, c_w, W, val, wt, memo):
#     #base case
#     if idx >= len(wt):
#       return 0
      
#     #memoization
#     if (idx, c_w) in memo:
#         return memo[(idx, c_w)]

#     #logic
#     incl = 0
#     if c_w + wt[idx] <= W:
#       incl = val[idx] + dp(idx + 1, c_w + wt[idx], W, val, wt, memo)

#     not_incl = dp(idx+1, c_w, W, val, wt, memo)

#     memo[(idx, c_w)] = max(incl, not_incl)
    
#     return memo[(idx, c_w)]
"""
TC: O(N*W) The time complexity is dominated by the nested loops in the iterative solution, where N is the number of items and W is the knapsack capacity.
SC: O(W) The space complexity is linear with respect to the knapsack capacity W, due to the one-dimensional DP array used for optimization.

Approach:

This problem is the classic **0/1 Knapsack problem**, solved here using two methods: **Memoization (Top-Down Dynamic Programming)** and **Tabulation (Bottom-Up Dynamic Programming)** with space optimization. The goal is to maximize the total value of items that can be placed in a knapsack without exceeding its weight capacity W, where each item can be included at most once.

1.  **Memoization ({dp} function)**: This recursive approach explores two choices for each item ({wt}{idx}]): **include** the item (if capacity allows) or **not include** it. The state is defined by {idx},{c\_w}), representing the current item index and the current total weight {c\_w}. The results are stored in the {memo} hash map to avoid re-calculation.
2.  **Tabulation ({knapsack} function)**: This optimized iterative solution uses a **one-dimensional DP array** {dp}{j}], where {dp}{j}] stores the maximum value for a knapsack of capacity {j}. The outer loop iterates through items, and the inner loop iterates through capacities **backward** (from W down to {wt}[i-1]). Iterating backward ensures that when {dp}{j} -{wt}[i-1]] is accessed, it still holds the maximum value computed *without* the current item, preventing the item from being included multiple times.

The final result is {dp}[W].

The problem ran successfully on GeeksForGeeks.
"""
def knapsack(W, val, wt):
    n = len(val)
    dp = [0]*(W+1)
    
    for i in range(1, n+1):
        
        for j in range(W, wt[i-1] - 1, -1):
            
            
            if j >= wt[i-1]:
                #compute
                dp[j] = max((val[i-1] + dp[j - wt[i-1]]), dp[j])

    
    return dp[-1]
            
                

if __name__ == "__main__":
    val = [1, 4, 5, 7]
    wt = [1, 3, 4, 5]
    W = 7

    print(knapsack(W, val, wt))