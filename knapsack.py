# Using Recurssion
# Time Complexity: O(2^n)
# Space Complexity: O(n)
def knapsackRecurssion(val: List[int], wt: List[int], w: int, n: int) -> int:
    # Base cases
    if n == 0 or w == 0:
        return 0
    
    # If the current item's weight is less than or equal to the remaining capacity
    if wt[n-1] <= w:
        # Choose the maximum of including or excluding the current item
        return max(val[n-1] + knapsack(val, wt, w - wt[n-1], n - 1), knapsack(val, wt, w, n - 1))
    else:
        # If the current item's weight exceeds the remaining capacity, exclude it
        return knapsack(val, wt, w, n - 1)

# Drivers code            
values = [60, 100, 120]
weights = [10, 20, 30]
capacity = 50
num_items = len(values) 
# Call the function with initial parameters
max_value = knapsackRecurssion(values, weights, capacity, num_items)
print("Maximum value that can be put in knapsack:", max_value)


# # using dp
def knapsack(val: List[int], wt: List[int], w: int, n: int) -> int:
    dp = [[0 for _ in range(w + 1)] for _ in range(n + 1)]
    # Base case: if the knapsack capacity is 0 or no items are left
    for i in range(n+1):
        for j in range(w+1):
            if i == 0 or j == 0:
                dp[i][j]=0
   
            # If the weight of the nth item is more than the knapsack capacity w, it cannot be included
            if wt[i-1] > j:  
                dp[i][j] = dp[i-1][j]
            if wt[i-1]<= j:
            # Store the value of the maximum of two cases:
            # (1) nth item included
            # (2) not included
                dp[i][j] = max(val[i-1] + dp[i-1][j-wt[i-1]], dp[i-1][j])
    
    return dp[n][w]
# Time Complexity: O(n*n)
# Space Complexity: O(n*n)
