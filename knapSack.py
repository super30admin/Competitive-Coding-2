'''
Time Complexity : O(M.N)
Space Complexity :O(M.N)
'''
class Solution:
    def canPartition(self, nums) -> bool:
        s = sum(nums)
        n = len(nums)
        if s % 2 != 0:
            return False
        s = int(s/2)
        
        dp = [[False for x in range(s+1)] for y in range(n)]
        
        for i in range(n):
            dp[i][0] = True
        
        for j in range(1, s+1):
            dp[0][j] = nums[0] == j
        
        for i in range(1, n):
            for j in range(1, s+1):
                if dp[i-1][j]:
                    dp[i][j] = dp[i-1][j]
                elif j >= nums[i]:
                    dp[i][j] = dp[i-1][j-nums[i]]
                    
        return dp[i-1][s]

s = Solution()
print(s.canPartition([1,5,11,5]))