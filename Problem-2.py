# Knapsack Problem
# https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/

# Brute Force
class BF_Solution:
    def _helper(self,values,weights,targetWeight, currvalue, idx):
    # Base case
        if idx == len(weights):
            if targetWeight >= 0:
                return currvalue
            else:
                return -1000000 # treat as minus infinity 
    
        nottaken = self._helper(values,weights,targetWeight, currvalue, idx+1)
        taken = self._helper(values,weights,targetWeight-weights[idx], currvalue+values[idx], idx+1)

        return max(nottaken,taken)

    def knapSack(self,values,weights,targetWeight):
        return self._helper(values,weights,targetWeight, 0, 0)

obj = BF_Solution()
# print(obj.knapSack([60,100,120],[1,2,3],5))
# print(obj.knapSack([60,10,120],[1,2,3],5))

# DP# Time Complexiety: O(length of weights * targetWeight)
# Space Complexiety: O(length of weights * targetWeight)
class DP_Solution:
    def knapSack(self,values,weights,targetWeight):
        dp = [[0]*(targetWeight+1) for i in range(len(weights)+1)]
        
        for row in range(1,len(weights)+1):
            for col in range(1,targetWeight+1):
                if col < weights[row-1]:
                    dp[row][col] = dp[row-1][col]
                else:
                    dp[row][col] = max(values[row-1] + dp[row-1][col-weights[row-1]],dp[row-1][col])
        return dp[len(weights)][targetWeight]

obj1 = DP_Solution()
print(obj1.knapSack([60,100,120],[1,2,3],5))
print(obj1.knapSack([60,100,120],[1,1,3],5))
