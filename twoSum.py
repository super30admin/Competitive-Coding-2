#TC:O(n^2)
#SC:O(1)
#Ran succeesfully on Leetcode:-Yes
#Iterate through the arrays and search if sum of two values at indices match the target or not

class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        for i in range (len(nums)):
            
             for j in range (i+1, len(nums)):
                sum=nums[i]+nums[j];
                if sum==target :
                    return [i,j]
