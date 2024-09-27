#Time Complexity : O(n)
# Space Complexity : O(n) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        buff_dict = {}
        for i in range(len(nums)):
            if nums[i] in buff_dict:
                return [buff_dict[nums[i]], i]
            else:
                buff_dict[target - nums[i]] = i
                