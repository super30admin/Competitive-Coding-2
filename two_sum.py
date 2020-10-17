class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        dict_s={}
        for i in range(len(nums)):
            dict_s[nums[i]] = i
        for i in range(len(nums)):
            complement = target - nums[i]
            if complement in dict_s and dict_s[complement] != i:
                return (dict_s[complement],i)
        