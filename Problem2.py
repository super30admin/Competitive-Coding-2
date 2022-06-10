'''
Time Complexity: O(n)
Space Complexity: O(n)
Run on Leetcode: YES
'''
class Solution:
    def twoSum(self, nums: list[int], target: int) -> list[int]:
        nMap = {}
        for index in range(len(nums)):
            if target - nums[index] in nMap.keys():
                return [nMap[target - nums[index]], index]
            nMap[nums[index]] = index