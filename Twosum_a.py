class TwoSum(object):
    '''
    Brute Force Solution:
    1. Check every possible pair of numbers.
    2. If the sum of a pair equals the target, return the indices of those two numbers.

    Time Complexity: O(n^2)
    Space Complexity: O(1)
    '''

    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        if nums is None or len(nums) < 2:
            return []

        n = len(nums)
        for i in range(n):
            for j in range(i + 1, n):
                if nums[i] + nums[j] == target:
                    return [i, j]

        return []
