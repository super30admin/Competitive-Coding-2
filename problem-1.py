# Time Complexity: O(n* capacity)
# space Complexity: O(n* capacity)
class Solution:

   def knapsack(self, capacity, profit, weights, n):
    #    we first make the dp of n+1 * capacity+1 becuase we want that first row and column to be 0
       dp = [[0 for _ in range(capacity+1)] for _ in range(n+1)]
        # we then calcuate and place 0 for first row and all the [i][j] values less than curretn weight[i] we copy from top row and place it 
        # for rest we get max of above row and above row and column- current weight and add current profit to it
       for i in range(0, n+1):

           for j in range(0, capacity+1):

               if i==0 or j==0:
                   dp[i][j]=0
             

               if j < weights[i-1]:

                   dp[i][j] = dp[i-1][j]

               else:

                   dp[i][j] = max(dp[i-1][j], dp[i-1][j-weights[i-1]]+profit[i-1])
        # we then return the final row and column value 
       return dp[n][capacity]

obj=Solution()
re=obj.knapsack(50,[60,100,120],[10,20,30],3)
print(re)