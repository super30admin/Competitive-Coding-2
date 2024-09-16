class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        if not nums:
            return [-1, -1]

        numsmap = {}

        for i in range(len(nums)):
            diff = target - nums[i]
            if diff in numsmap:
                return [i, numsmap[diff]]
            else:
                numsmap[nums[i]] = i
        print(numsmap)
        return [-1, -1]