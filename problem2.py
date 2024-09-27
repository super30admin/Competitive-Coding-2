##Time Complexity : O(n)
##Space Complexity :O(n)
##Did this code successfully run on Leetcode : Yes
class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        lib = {}
        for i, n in enumerate(nums):
            diff = target-n
            if diff in lib:
                return[lib[diff], i]
            lib[n] = i
        return