"""
Problem:
Two Sum
https://leetcode.com/problems/two-sum/

Mock Interview Solutions
https://youtu.be/7OmlSGNQZTo

Time Complexity : O(n)
Space Complexity : O(n)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Your code here along with comments explaining your approach:
Iterate over elements. Substract the target and find if difference is there in hash map.
If found return the current index and the stored index in hashmap for the specific number else
store the number and it's index. 
"""

# Approach 1 using hash_map
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        if not nums or len(nums) == 0:
            return [-1, -1]
        
        hash_map = {}

        for i in range(len(nums)):
            target_diff = target - nums[i]
            if target_diff in hash_map:
                return [i, hash_map[target_diff]]
            hash_map[nums[i]] = i


# Approach 2 using 2 pointer
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        
        nums_with_idx = []

        for i in range(len(nums)):
            nums_with_idx.append((nums[i], i))
        
        nums_with_idx.sort(key = lambda x: x[0])
        
        i, j = 0, len(nums) - 1

        while i <= j:
            curr_tar = nums_with_idx[i][0] +  nums_with_idx[j][0]

            if curr_tar == target:
                return [nums_with_idx[i][1], nums_with_idx[j][1]]
            elif curr_tar > target:
                j -= 1
            else:
                i += 1


            
        