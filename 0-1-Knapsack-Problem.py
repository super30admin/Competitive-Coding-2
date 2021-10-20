def knapsack(vals, weights, W):
    taken = weights[0]
    not_taken  = 0
    taken_val  = vals[0]
    not_taken_val = 0
    mx = max(taken_val, not_taken_val)
    for i in range(len(vals)):
        not_taken = max(not_taken, taken)
        not_taken_val = max(not_taken_val, taken_val)
        if taken+weights[i] < W:
            taken += weights[i]
            taken_val += vals[i]
    return max(taken_val, not_taken_val)
