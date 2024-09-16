# Time Complexity : O(N)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Three line explanation of solution in plain english
'''Calculate difference of current number with target. This will be stored in the map. I will query the map with the current number.'''
# Your code here along with comments explaining your approach

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        d = {}
        for i in range(len(nums)):
            diff = target - nums[i]
            if nums[i] in d:
                return [i, d[nums[i]]]
            else:
                d[diff] = i
        return -1