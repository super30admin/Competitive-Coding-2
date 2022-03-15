
    # 1. Two Sum
    # Time Complexity : O(n)
    # Space Complexity : O(n)
  

class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        searchDiff = {}  # Space complexity: O(n)

        for i in range(len(nums)):  # O(n)
            diff = target - nums[i]
            if diff in searchDiff:  # O(1) for lookup
                return [searchDiff[diff], i]
            else:
                searchDiff[nums[i]] = i
                
                