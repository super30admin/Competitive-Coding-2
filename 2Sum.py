"""1. Two Sum
Time Complexity - O(n)
Space Complexity - O(n)
Storing value of target- nums[i] in dictionary and verifying if element in dictionary"""
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        output = {}
        for i in range(len(nums)):
            if nums[i] in output:
                return [output[nums[i]],i]
            else:
                output[target- nums[i]] = i
        return [-1,-1]