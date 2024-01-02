class Solution:

    #Function to return max value that can be put in knapsack of capacity W.
    def knapSack(self,W, weight, profit, n):

        matrix = [[] for i in range(len(weight)+1)]
        matrix[0] = [0] * (W+1)

        for i in range(1,len(profit)+1):
            for j in range(W+1):
                if j >= weight[i-1]:
                    matrix[i].append(max((profit[i-1] + matrix[i-1][j-weight[i-1]]),matrix[i-1][j]))

                else:
                    matrix[i].append(matrix[i-1][j])

        return matrix[-1][-1]