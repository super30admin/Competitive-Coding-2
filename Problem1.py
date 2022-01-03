# Time Complexity: O(n)
# Space Complexity: O(n)
class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        hashmap = {}
        for i in range(len(nums)):
            if hashmap.has_key(target-nums[i]):
                return [hashmap[target-nums[i]], i]
            hashmap[nums[i]] = i