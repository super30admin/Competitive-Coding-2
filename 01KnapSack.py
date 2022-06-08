# Time Complexity: O(2^n)
# Space Complexity: O(1)
  
class Solution:
    def helper(self, W, wt, val, n, i, maxCost):
        if i == len(val) or W == 0:
            return maxCost
        
        if wt[i] > W:
            return self.helper(W, wt, val, n, i+1, maxCost)
        
        #no choose
        case1 = self.helper(W, wt, val, n, i+1, maxCost)
        #choose
        case2 = self.helper(W-wt[i], wt, val, n, i+1, maxCost+val[i])
        
        return max(case1, case2)
    #Function to return max value that can be put in knapsack of capacity W.
    def knapSack(self,W, wt, val, n):
        
        return self.helper(W, wt, val, n, 0, 0)
