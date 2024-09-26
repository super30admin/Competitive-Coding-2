# Given nums = [2, 7, 11, 15], target = 9,
# Because nums[0] + nums[1] = 2 + 7 = 9,
# return [0, 1].


# Code:

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        
        mapping = {}
        
        for i in range(len(nums)):
            if target-nums[i] in mapping:
                return [mapping[target-nums[i]], i]
            else:
                mapping[nums[i]] = i
        
        return [-1,-1]
        


# Time Complexity = O(N)
# Space Complexity = O(N)
# Leetcode accepted: YES.
# Difficulty faced : No.