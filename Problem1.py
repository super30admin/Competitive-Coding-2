"""
Worked on leetcode: Yes
interview question


https://leetcode.com/problems/two-sum/description/
"""

class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        #make a hash set/map
        num_map = {}

        for i,  num in enumerate(nums):
            difference = target - num

            if difference in num_map:
                return[num_map[difference],i]

            num_map[num] =i

        return []
    