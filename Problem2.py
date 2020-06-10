# Time Complexity : O(m x n) where m = cap + 1 and n = no. of weight+1
# Space Complexity :O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
class Solution:
    # Time = O(2^n) time | O(h) space, where h is the height of the tree.
    # def knapSack(self,weight,value,cap):
    #     if cap == 0:
    #         return 0 
    #     if not weight or not value:
    #         return 0 
    #     return self.helper(weight,value,cap,0,0,0)

    # def helper(self,weight,value,cap,currweight,currcap,index):
    #     if currweight == cap:
    #         return currcap 
    #     if currweight > cap:
    #         return 0 
    #     if index == len(weight):
    #         return 0 
        
    #     #choose 
    #     case1 = self.helper(weight,value,cap,currweight+weight[index],currcap+value[index],index+1)
    #     #not choose
    #     case2 = self.helper(weight,value,cap,currweight,currcap,index+1)
        
    #     return max(case1,case2)
    
    # Time = O(m x n) where m = cap + 1 and n = no. of weight+1 | O(1) space 
    def knapSack(self,weight,value,cap):
        if cap == 0:
            return 0 
        if not weight or not value:
            return 0 
        dp = [[0 for _ in range(cap+1)] for _ in range(len(weight)+1)]
        
        for i in range(1,len(dp)):
            for j in range(1,len(dp[0])):
                if weight[i-1] < cap:
                    dp[i][j] = max(dp[i-1][j], value[i-1]+ dp[i-1][j-weight[i-1]])
                else:
                    dp[i][j] = dp[i-1][j]
        return dp[-1][-1]
                    
    
if __name__ == "__main__":
    s = Solution()
    weight = [10,20,30]
    value = [60,100,120]
    cap = 50 
    res = s.knapSack(weight,value,cap) 
    print(res)