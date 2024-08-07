#// Time Complexity : O() 
# // Space Complexity : O() 
# // Did this code successfully run on Leetcode : yes. TLE
# // Any problem you faced while coding this : i was not able to convert it into Dp.

class Solution:
    
    #Function to return max value that can be put in knapsack of capacity W.
    def knapSack(self,W, wt,val, n):
       
        # code here
      
        
        def helper(wt,idx,W):
        
            if idx >= len(wt) or W <= 0:
                return 0
            
            if wt[idx] > W:
                
               return  helper(wt,idx+1,W)
            else:    
                
                take =  val[idx] + helper(wt ,idx+1, W-wt[idx])
            
                notake = helper(wt,idx+1,W)
            
                return max(take, notake)
       
                
        return helper(wt,0,W)

# Approach:
# The problem can be solved using a recursive approach. The idea is to consider each item one by one
# and decide whether to include it in the knapsack or not. If the weight of the current
# item is more than the remaining capacity, we simply skip it and move to the next item. If
# the weight of the current item is less than or equal to the remaining capacity, we have two options
# either include the current item in the knapsack or not. We recursively call the function for both
# options and return the maximum value.