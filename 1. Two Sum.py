# // Time Complexity : O(n)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach
# Iterate through all the elements of the list
# calculate the complement at each step
# check of the complement exists in the Map that is crated:
# if yes return the current elements index and the complement elements index from the map
# else add the current element to the map with its index

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        if not nums:
            return [-1,-1]
        
        Map = {}
        for i in range(len(nums)):
            complement = target - nums[i]
            if complement in Map.keys():
                return [i,Map[complement]]
            Map[nums[i]] = i
        return [-1,-1]
        
        