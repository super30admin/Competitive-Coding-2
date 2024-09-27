# Leetcode 740. Delete and Earn

# Time Complexity :  O(n) where n is the size of the array 

# Space Complexity : O(n) where n is the size of the array 

# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Approach: Iterate through the array and check if the difference between the target and value in array 
# is present in hashmap. If its present return the index of the compliment and the index of the current value.
# Else add the current value and its index to the hashmap.

# Your code here along with comments explaining your approach

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        hmap = dict()
        
        for i in range(len(nums)):
            comp = target-nums[i]
            if comp in hmap:
                return [hmap[comp],i]
            else:
                hmap[nums[i]] = i