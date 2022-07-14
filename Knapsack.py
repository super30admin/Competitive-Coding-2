def knapsack(maxWeight, weight, amt, n):

    # Base Case
    if n == 0 or maxWeight == 0:
        return 0

    if (weight[n-1] > maxWeight):
        return knapSack(maxWeight, weight, amt, n-1)
 
    else:
        return max(
            val[n-1] + knapSack(
                maxWeight-weight[n-1], weight, amt, n-1),
            knapSack(maxWeight, weight, amt, n-1))
 
