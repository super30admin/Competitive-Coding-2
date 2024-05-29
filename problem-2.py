# Time Complexity
# O(n * m), n - rows , m- columns
# Space Complexity
# O(n * m), n - rows , m- columns

# Approach :

# in knapsack problem we are maximizing the value while maintaining the weight to not go beyond the bag's capacity
# if the weight of the object is greater than the weight of the bag just return the arr[i-1][j] th index value
# else , we compare the value between the arr[i-1][j] th index value and the value of the current element given by ( val[i-1]) and after subtracting the current elements weight from the bag capacity
# if there are elements which can be added in the remaining weight which is given arr[i-1][j-wt[i-1]]
# after comparing we take the max value between these elements.


class Solution:

    def knapSack(self, W, wt, val, n):

        rangeRows = range(len(wt)+1)
        arr = [[0 for i in range(0, W+1)] for i in rangeRows]

        for i in rangeRows:
            arr[i][0] = 0

        for i in range(1, len(wt)+1):
            for j in range(W+1):
                if (wt[i-1] > j):
                    arr[i][j] = arr[i-1][j]
                else:
                    arr[i][j] = max(arr[i-1][j], val[i-1]+arr[i-1][j-wt[i-1]])

        return arr[i][j]
