"""
Question Link : https://leetcode.com/problems/two-sum/

Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

 

Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Output: Because nums[0] + nums[1] == 9, we return [0, 1].
Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]
Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]
"""
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        """
        Create a Dictionary.
        Loop through the number array.
        If the number not in dictionary, insert number as key and index as value.
        Find target-nums[i] in dictionary if found return indexes
        
        Note: return(i) == return([i])
        
        Time Complexity: O(n)
        Space Complexity: O(n) - for dictionary
        
        """
        dictionary = {}
        for i in range(len(nums)):
            if target-nums[i] in dictionary:
                return ([i , dictionary[target-nums[i]]])
            if nums[i] not in dictionary:
                dictionary[nums[i]] = i