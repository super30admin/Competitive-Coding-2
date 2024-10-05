#1. Two Sum
class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        hash_map = {}

        for i in range(len(nums)): #O(N)
            comp = target - nums[i]

            if comp in hash_map:
                return [hash_map[comp],i]
            hash_map[nums[i]] = i 
        
        