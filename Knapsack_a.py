def knapsack_recursive(maxW, weights, values, n):
    '''
    time complexity - O(2^n)
    space complexity - O(n)

    '''
    # Base case: If there are no items left or maximum weight is 0
    if n == 0 or maxW == 0:
        return 0

    # If the weight of the nth item exceeds the maximum weight, skip it
    if weights[n-1] > maxW:
        return knapsack_recursive(maxW, weights, values, n-1)

    # Recursive calls for choosing or not choosing the nth item
    # Choose the nth item and reduce the maximum weight and number of items
    choose = values[n-1] + \
        knapsack_recursive(maxW - weights[n-1], weights, values, n-1)
    # Don't choose the nth item and move to the next item
    dont_choose = knapsack_recursive(maxW, weights, values, n-1)

    # Return the maximum value obtained by choosing or not choosing the nth item
    return max(choose, dont_choose)


# Example usage
values = [60, 100, 120]
weights = [10, 20, 30]
maxWeight = 50
numItems = len(values)
maxValue = knapsack_recursive(maxWeight, weights, values, numItems)
print(maxValue)
