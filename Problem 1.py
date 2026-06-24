#Problem 1 : TWO SUM 
# TIME COMPELXITY: O(N) where N denotes number of elements since we need to get complement to
# see which one makes a pair
# SPACE COMPLEXITY: O(N) given that we are initializing a map to find the number and its index

class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        reference={}
        for i in range(len(nums)):
            complement=target-nums[i]
            if complement in reference:
                return[reference[complement],i]
            reference[nums[i]]=i