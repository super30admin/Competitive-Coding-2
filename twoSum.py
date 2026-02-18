# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Approach: Use a hashmap to store (number : index) for numbers seen so far.
# For each nums[i], check if its complement (target - nums[i]) already exists in the hashmap.
# If yes, return the stored index and current index, otherwise store nums[i] with its index.


class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        h_map = {}
        for i in range(len(nums)):
            if target - nums[i] in h_map:
                return [h_map[target - nums[i]], i]
            h_map[nums[i]] = i
        
        return [-1, -1]

