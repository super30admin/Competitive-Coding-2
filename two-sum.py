"""

Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]

Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]

Time Complexity: O(n) 
Space Complexity: O(n) 

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

"""

# Approach:
# 1. Use a hash map to store the indices of numbers as we iterate through the list.
# 2. For each number, check if the complement (target - num) exists in the hash map.
# 3. If found, return the current index and the stored index; otherwise, add the number to the hash map.


class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        hmap = {}

        for i, num in enumerate(nums):
            if target - num in hmap:
                return [i, hmap[target - num]]
            
            hmap[num] = i
