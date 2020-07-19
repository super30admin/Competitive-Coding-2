
class Solution:
  def knapsack(self,BagCapacity,itemsweight):
    self.dp=[[0 for y in range(len(BagCapacity)+1)] for x in range(len(items)+1)]
    for i in range(1,len(dp):
      for j in range(1,len(dp[0]):
        dp[i][j]=max(dp[i-1][j],dp[i-1][j-itemsweight[i-1])
    return dp[len(dp)-1][len(dp[0]-1])
#time is O(len(itemsWeight)BagCapacity)
#space is same as time.                        
                         
