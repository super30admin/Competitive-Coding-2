# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        dict1={}
        for i in range(len(nums)):
            if target-nums[i] in dict1.keys():
                return [dict1[target-nums[i]],i]
            else:
                dict1[nums[i]] = i
        return [-1,-1]