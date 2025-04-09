
# Time Complexity: O(m*n)
# Space Complexity: O(m*n)
from typing import List
def knapsack(profit: List[int], weight: List[int], capacity: int):
         m = len(weight)
         n = capacity
         dp = [[0] * (capacity+1) for _ in range(m+1)]
         
         for i in range(1,m+1):
             for j in range(1, n+1):
                 if j < weight[i-1]:
                    dp[i][j] = dp[i-1][j]
                 else:
                    dp[i][j] = max(dp[i-1][j], profit[i-1]+dp[i-1][j-weight[i-1]])
         return dp[m][n]
     
if __name__ == "__main__":
    profit = [60, 100, 120]
    weight = [10, 20, 30]
    capacity = 50
    
    print(knapsack(profit, weight, capacity))              
        
