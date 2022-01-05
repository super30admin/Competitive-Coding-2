# // Time Complexity : O(1)
# // Space Complexity : O(M)
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this :


# // Your code here along with comments explaining your approach

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        
        numSet = {}
        
        for i, num in enumerate(nums):
            
            if target - num in numSet.keys():
                return[numSet[target-num],i]
            else:
                numSet[num] = i
