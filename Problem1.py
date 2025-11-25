"""
We store the numbers we encounter with its index as the value and number itself as the key and then search for the complement of that number,
if its already seen, return its index along with current index else add it to hmap
TC is O(n) for iterating through all elements and space is o(n) for storing"""


class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        hmap = {}

        for i in range(len(nums)):
            complement = target - nums[i]
            if complement in hmap:
                return [hmap[complement], i]
            else:
                hmap[nums[i]] = i
