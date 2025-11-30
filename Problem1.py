# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode :yes
# Any problem you faced while coding this :no


# Your code here along with comments explaining your approach
# created array to track the previously visited elements with index
# then checked if the subtraction of target and nums[i] in the prev tracked elements
# if there returned that index with the current index
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        prev_visited_elements = {}
        for i in range (len(nums)):
            if target-nums[i] in prev_visited_elements:
                return [prev_visited_elements[target - nums[i]], i]
            prev_visited_elements[nums[i]]=i
        
        