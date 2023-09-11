# Time Complexity : O(n)
# Space Complexity: O(n)

class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        dict = {}
        
        for i in range(len(nums)):
            x = target - nums[i]
            if x in dict:
                return [i, dict[x]]
            dict[nums[i]] = i
