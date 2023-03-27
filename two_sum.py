# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
"""
In this code we are using a hashmap to store the difference between the target and the current.
And then when iterating through the array we find the difference in the hashmap and return the 
index of the difference and the current index.
"""
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        hashmap = collections.defaultdict(int)

        for i in range(len(nums)):
            if nums[i] in hashmap:
                return [hashmap[nums[i]], i]

            hashmap[target - nums[i]] = i