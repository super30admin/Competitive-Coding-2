#TC: O(2^n)
#SC: O(n) for recursive stack

def knapsack(weights, w, vals, n):
    #base case
    if n==0 or w==0:
        return 0
    #edge case
    elif weights[n-1]>w:
        return knapsack(weights, w, vals, n-1)
    else:
        #select and no select
        return max(
            (vals[n-1] +
            knapsack(weights, w-weights[n-1], vals, n-1)),
            (knapsack(weights, w-weights[n-1], vals, n-1)))

vals = [60, 100, 120]
weights = [10, 20, 30]
w = 50
n = len(vals)
print(knapsack(weights, w, vals, n))