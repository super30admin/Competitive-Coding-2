class TwoSum(object):
    '''
    Solution:
    1.  Maintain a HashMap of numbers and their indices.
    2. If a number's compliment such that both the numbers add to target, then return indices of those two numbers.

    --- Passed all testcases on Leetcode successfully
    Time Complexity: O(n) | Space Complexity: O(n)
    '''
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """

        if (nums == None or len(nums) == 0):
            return [-1, -1]

        dictIndices = {}
        dictSeconds = {}

        for i in range(len(nums)):
            if nums[i] not in dictIndices:
                dictIndices[nums[i]] = i
            else:
                dictSeconds[nums[i]] = i

        for i in range(len(nums)):
            if (target - nums[i] != nums[i]) and ((target - nums[i]) in dictIndices):
                return [dictIndices[nums[i]], dictIndices[target - nums[i]]]
            elif (target - nums[i] == nums[i]) and (target - nums[i] in dictSeconds):
                return [dictIndices[nums[i]], dictSeconds[target - nums[i]]]

        return [-1, -1]