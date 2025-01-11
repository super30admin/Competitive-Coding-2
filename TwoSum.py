    # Time Complexity : 0(n)
    # Space Complexity : 0(n)
    # Did this code successfully run on Leetcode : Yes
    # Any problem you faced while coding this : NA

from typing import List


class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        two_sum = {}
        diff = 0
        for i in range(len(nums)):
            diff = target - nums[i]
            if diff in two_sum:
                return [i, two_sum[diff]]
            else:
                two_sum[nums[i]] = i