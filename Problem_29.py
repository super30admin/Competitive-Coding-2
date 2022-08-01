# Time Complexity : O(n) where n = len(nums)
# Space Complexity : O(n) for the hashmap
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        h = {} # Initialize a hash map
        for i in range(len(nums)):
            complement = target - nums[i] # Compute complement of current nums[i] with target i.e  nums[i] + complement = target
            if complement in h.keys():
                # If complement is found in the keys return the pair
                return [i,h[complement]]
            h[nums[i]] = i # Add nums[i] as a key to the hashmap with any value