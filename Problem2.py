# Time Complexity : O(n^2)
# Space Complexity: O(m*n), the array with dimensions mXn

# 0/1 KnapSack Problem
# Here we create a 2d array with columns as the possible weights up to the max capacity
# and rows as number of items (used to access the weight and value of the current item)
def knapSack(capacity, weights, values, items):
    # code here
    knap = [[0 for _ in range(capacity+1)] for _ in range(items+1)]
    rows = len(knap)
    cols = len(knap[0])

    for i in range(1,rows):
        for j in range(1,cols):

            # if the current weight is more than the allowed weight we can't take the item
            # and hence copy the value from above denoting the max value from the remaining coins
            # for the allowed weight
            if weights[i-1] > j:
                knap[i][j] = knap[i-1][j]
            # Here we only have one of each item and not an unlimited supply
            # So we check the max of
            # (current val + the max value for the remaining weight) and (val if we don't pick the current item)
            else:
                knap[i][j] = max(values[i-1]+knap[i-1][j-wt[i-1]], knap[i-1][j])

    # the last element of the 2d array will have the max value for the allowed weight
    return knap[rows-1][cols-1]