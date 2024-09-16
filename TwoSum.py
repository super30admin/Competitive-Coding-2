# Time complexity is O(N)
# Space complexity is O(N)
class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        mem = {}
        for i in range(len(nums)):
            if nums[i] in mem:
                return [mem[nums[i]],i]
            mem[target - nums[i]] = i
        return []