"""Explanation: Simple store the number and the frequency in a hashap and search based on the given target
   Time Complexcity: O(n)
   Space Complexcity: O(1)
"""


class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        dict={}
        for i,n in enumerate(nums):
            if n in dict:
                return dict[n],i
            else:
                dict[target-n]=i
        