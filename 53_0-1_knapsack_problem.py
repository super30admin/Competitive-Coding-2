# Time complexity - O(n * w)
# Space complexity - O(w)

# Approach - maintain a dp array, start computation from back to maximize profit, return the last element 
# value of dp array 

from typing import List
class Solution:
    def knapSack(self, n: int, w: int, profit: List[int], weight: List[int]) -> int:        
        dp = [0 for i in range(w+1)]

        for i in range(1, n+1):
            for j in range(w, 0, -1):
                if weight[i-1] <= j:
                    # Finding the maximum value
                    # print(i, j, weight[i-1], profit[i-1], dp[j], dp[j-weight[i-1]])
                    dp[j] = max(dp[j], dp[j-weight[i-1]] + profit[i-1])
                    
        return dp[w]

sol = Solution()
# out = sol.knapSack(n=3, w=4, profit= [1,2,3], weight=[4,5,1])
# out = sol.knapSack(n=3, w=3, profit=[1,2,3], weight=[4,5,6])
out = sol.knapSack(n=3, w=50, profit=[60,100,120], weight=[10,20,30])
print(out)