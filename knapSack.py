# Time Complexity : O(n * W) where n is the number weighted elements and W is the capacity
# Space Complexity : O(n * W) where n is the number weighted elements and W is the capacity
# Did this code successfully run on LeetCode :  yes
# Any problem you faced while coding this : no



def knapSack(W, wt, val, n):

#We create a dynamic Matrix to keep track the value of previous weights possibilities for the capacities.
    dpMatrix = [[0 for x in range(W + 1)] for x in range(n + 1)]

    for i in range(n + 1):
        for w in range(W + 1):

            #Since we cannot fill anything with 0 , we make 0 row, 0 column as 0s
            if i == 0 or w == 0:
                dpMatrix[i][w] = 0

            # if previous weight is less than current, we will take the max of previous value + differnece to get the current value
            # and previous weight for the current value.
            elif wt[i - 1] <= w:
                dpMatrix[i][w] = max(val[i - 1] + dpMatrix[i - 1][w - wt[i - 1]], dpMatrix[i - 1][w])
            else:
                #We will take the previous one
                dpMatrix[i][w] = dpMatrix[i - 1][w]

    return dpMatrix[n][W]
