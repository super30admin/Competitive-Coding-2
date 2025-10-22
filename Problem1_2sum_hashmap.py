class Solution(object):
    def twoSum(self, nums, target):
        """
        Hashmap: Time complexity O(n) ans search is O(1) and space: O(n)
        Note: You add the element from array into hashamp and 
        check if complement exists if so return the element.
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        n = len(nums)
        map = {}
        for i in range(0, n):
            complement = target - nums[i]
            if complement in map:
                return[map[complement], i]
            map[nums[i]] = i

        return []