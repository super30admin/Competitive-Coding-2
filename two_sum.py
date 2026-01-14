"""
space = o(n)
time = o(n)
store numbers in a dictionary and if we have it's complement as seen before
we return the two nunmbers
"""

from typing import List


class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        seen = {}
        for i in range(len(nums)):
            complement = target - nums[i]
            if complement in seen:
                return [i, seen[complement]]
            seen[nums[i]] = i
