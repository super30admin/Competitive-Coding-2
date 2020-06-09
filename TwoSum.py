"""
// Time Complexity : o(n), where n  is the number of elements 
// Space Complexity : o(n), using a dictionary
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

"""

from collections import defaultdict
class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        d = defaultdict(int) 
        for i in range(len(nums)): # for all elements in dictionary
            comp = target - nums[i] #calculating the complement 
            
            if comp in d:
                return [d[comp], i] #if complemnt exist then return the index of complement and current index
            else:
                d[nums[i]] = i #else add that value to dictionary with value as its index
                
        return [-1,-1]  