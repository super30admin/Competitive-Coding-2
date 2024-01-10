#User function Template for python3

class Solution:
    
    #Function to return max value that can be put in knapsack of capacity W.
    def knapSack(self,W, wt, val, n):
       
        # def helper(W,wt,val,index,curWt,curVal):
        #     #base condition
        #     if index > len(wt) or curWt > W:
        #         return -1
        #     if index == len(wt):
        #         return curVal
        #     #logic
        #     #do not select
        #     case1 = helper(W,wt,val,index+1,curWt,curVal)
        #     #select
        #     case2 = helper(W,wt,val,index+1,curWt+wt[index],curVal+val[index])
        #     return max(case1,case2)
        # return helper(W,wt,val,0,0,0)
        
        #dp solution
        #make array of size wt+1 * Capacity+1
        dp = [[0 for i in range(W+1)] for j in range(len(wt)+1)]
        
        # for the first row, which is dummy row, all values are 0
        for idx,el in enumerate(dp[0]):
            dp[0][idx] = 0
        # starting from the first row, the matrix is populated with the max value considering only that index item
        for i in range(1,len(dp)):
            for j in range(1,len(dp[0])):
                # if the capacity is less than the item weight, copy from the above row
                if j<wt[i-1]:
                    dp[i][j] = dp[i-1][j]
                else:
                    # the value of the item is the max of not considering that item and if that item is considered, what can be found for the remaining weight
                    dp[i][j] = max(dp[i-1][j],val[i-1]+dp[i-1][j-wt[i-1]])
        # return last element which is the max value with capacity constraint
        return dp[-1][-1]