# Time Complexity : O(n*m) - n is length of nums and m id the sum(nums)/2
# Space Complexity : O(n*m) - n is length of nums and m id the sum(nums)/2
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

"""
If sum of nums is odd, it won't be possible to partition the array into two parts with equal sum,
so return False,

If sum of nums is even,
we can check if we are able to create a sub array with sum/2
then it is possible to partition the array into two parts with equal sum
as other sub array's sum would also be sum/2.

So, for index i at nums[] and target x, we either take that number OR
don't take that number.

If doing either returns true, that means it is possible to create sub
array with sum = target by using numbers upto i in nums

Recursion

Base condition:

if target == 0: return True
if target < 0 or i == n; return False

return self.helper(nums,i+1,target-nums[i])  (pick nums[i])
OR
self.helper(nums,i+1, target) (do not pick nums[i])
"""


class Solution(object):
    def canPartition(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """

        n = len(nums)
        nums_sum = 0
        for i in range(0, n):
            nums_sum += nums[i]

        # if sum of the array is odd, it is not possible two partition the
        # main array into two sub arrays with equal sum
        if nums_sum % 2 != 0:
            return False

        # if we are able to meet a target of sum/2 using a sub array, then we can partition main
        # array into two sub arrays with equal sum
        target = nums_sum // 2

        # dp matrix to store whether forming target (0 to target)
        # is possible with numbers (nums[0] to nums[n])
        dp = [[False for i in range(0, target + 1)] for i in range(0, n + 1)]

        # setting first column as True, as it is possible to make amount 0 with any number
        for i in range(0, n + 1):
            dp[i][0] = True

        for i in range(1, n + 1):
            for j in range(1, target + 1):
                # if the target < value of current number, that number cannot be taken,
                # just consider the result without this number, which is one row above
                if j < nums[i - 1]:
                    dp[i][j] = dp[i - 1][j]
                # consider result without this number or result with this number
                else:
                    dp[i][j] = dp[i - 1][j] or dp[i - 1][j - nums[i - 1]]
        return dp[n][target]