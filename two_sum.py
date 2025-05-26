"""
TC->O(n)
SC ->O(n)
"""
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        lookup = {}
        for i in range(len(nums)):
            diff = target-nums[i]
            if diff in lookup:
                return [i,lookup[diff]]
            lookup[nums[i]]=i