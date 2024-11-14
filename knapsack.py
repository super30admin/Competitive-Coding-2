# The code defines a knapSack method to solve the 0/1 Knapsack problem using recursion.
# Given weights (wt) and values (val) of items, along with a knapsack capacity W, the function finds the maximum value that can be obtained without exceeding W.

# Base Case:
#   - If there are no items left (n == 0) or the capacity W is 0, return 0 as no value can be achieved in these cases.

# Recursive Case:
#   - If the weight of the nth item (wt[n-1]) is greater than W, it cannot be included in the knapsack:
#       - Skip the item and call knapSack on the remaining items with the same capacity, W.
#   - Otherwise, we have two choices:
#       - Include the nth item:
#           - Add its value (val[n-1]) to the result and reduce the capacity by its weight (W - wt[n-1]).
#           - Call knapSack on the remaining items with this reduced capacity.
#       - Exclude the nth item and move to the next.
#       - Return the maximum value between including and excluding the item.

# Main Execution:
#   - If executed as a script, a sample list of profits (values) and weights is provided along with a knapsack capacity W.
#   - The knapSack function is called with the sample inputs, and the result (maximum achievable value) is printed.

# TC: O(2^n) - The time complexity is exponential due to all possible subsets being explored recursively.
# SC: O(n) - The space complexity is linear for the recursion stack up to n levels deep.


def knapSack(W, wt, val, n):

    if n == 0 or W == 0:
        return 0

    if wt[n-1] > W:
        return knapSack(W, wt, val, n-1)
    else:
        return max(
            val[n-1] + knapSack(W-wt[n-1], wt, val, n-1),
            knapSack(W, wt, val, n-1)
        )

if __name__ == '__main__':
    profit = [60, 100, 120]
    weight = [10, 20, 30]
    W = 50
    n = len(profit)
    print(knapSack(W, weight, profit, n))
