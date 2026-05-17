
# https://leetcode.com/problems/two-sum/description/

class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        dict_field={}
        for i in range(len(nums)):
            if nums[i] in dict_field:
                dict_field[nums[i]].append(i)
                return dict_field[nums[i]]
            val = target-nums[i] 
            dict_field[val] = [i]
        return []
            