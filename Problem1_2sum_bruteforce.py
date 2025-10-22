class Solution(object):
    def twoSum(self, nums, target):
        """
        Brute Force Method: O(n^2)
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        n = len(nums)
        for i in range(n):
            for j in range(i):
                if (nums[i]+nums[j]) == target:
                    return [i, j]
        return []