""" Explanation: Solved the problem usign DP. Initializes a 2D DP table t with dimensions (n + 1) x (s1 + 1). The element t[i][j] represents
    the number of ways to achieve the sum j using the first i elements of the array. Then we iterate over the dp table and consider two 
    cases for each table, if nums[i-1] <= j or nums[i-1] > j and decide whether the current element should be include to the sum or not.
    Time Complexcity: O(n*s1)
    Space Complexcity: O(n*s1)
"""


class Solution(object):
    def findTargetSumWays(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        sumOfNums = sum(nums)
        n = len(nums)
        
        if abs(target) > sumOfNums:
            return 0

        if (target + sumOfNums) % 2 != 0:
            return 0
        
        s1 = (sumOfNums + target) // 2
        
        # DP Table
        t = [[0] * (s1 + 1) for i in range(n + 1)]
		
        t[0][0] = 1
        
        for i in range(1, n + 1):
            for j in range(s1 + 1):
                
                if nums[i - 1] <= j:
                    t[i][j] = t[i - 1][j] + t[i - 1][j - nums[i - 1]]
                
                else:
                    t[i][j] = t[i-1][j]
            
        return t[n][s1]
        