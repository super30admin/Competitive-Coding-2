# Two Sum
# T.C = O(n) S.C = O(n)
class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        n = len(nums)
        num_dict = {}

        for i in range(n):
            component = target - nums[i]
            if component in num_dict:
                return [num_dict[component],i]
            num_dict[nums[i]] = i