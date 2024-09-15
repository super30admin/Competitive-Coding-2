"""
Time Complexity : O(n)
Space Complexity : O(n)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
"""
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        # Initialize dictionary
        mainDict = {}
        if len(nums) == 0:
            return [-1,-1]
        else:
            # We traverse through the array and subtract each element 
            # from the target and store its index in map
            # if we find the any element in the map already we return its
            # value from map and the currect index at which element
            # was found
            for i in range(len(nums)):
                if nums[i] in mainDict:
                    return [mainDict[nums[i]], i]
                else:
                    mainDict[target - nums[i]] = i
            return [-1, -1]