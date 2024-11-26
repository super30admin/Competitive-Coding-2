class Solution:
    #Function to return max value that can be put in knapsack of capacity W.
    def knapSack(self,  profits, weights, capacity):
         ## Case where the weight is same as capacity
         if capacity == sum(weights):
           return sum(profits)
         matrix = [[0]*(capacity +1)] * (len(weights) + 1)
         print()
         for i in range(1,len(weights)+1):
            for j in range(1,capacity+1):
                if j - weights[i-1] >= 0 :
                    matrix[i][j] = max(matrix[i - 1][j], matrix[i-1][j - weights[i-1]]+ profits[i - 1])
                else:
                    matrix[i][j] = matrix[i-1][j]
         return matrix[-1][-1]
