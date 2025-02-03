# Time Complexity : O(n) - n is length of nums
# Space Complexity : O(n) - n is length of nums
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

"""
We use a map to store the index of the numbers we have encountered so far,
Then we iterate through the nums list,
if nums[i] not in map, put it with i as the value
else if (target - nums[i]) in map, return [map[target - nums[i]], i]

"""
class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """

        index_map = {}

        for i in range(0,len(nums)):
            if target - nums[i] in index_map:
                return [index_map[target - nums[i]], i]
            else:
                index_map[nums[i]] = i

        return [-1,-1]