#LC 1 - Two Sum
#Time Complexity - O(n)
#Space Complexity - O(n)
class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        d = dict()
        for i in range(len(nums)):
            if nums[i] not in d.keys():
                d[target-nums[i]] = i
            elif nums[i] in d.keys():
                if i != d[nums[i]]:
                    return [d[nums[i]],i]
                