"""
Author: Srinidhi Bhat
Time Complexity: O(n)
Space Complexity: O(n) - Hashmap

Logic: For each number in nums, store the possible remaining sum required
for each number in a hashmap. Hence for every iteration, check if the
remaining number exists from before and if it does, return the position

hashmap structure: Number: position
"""
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        my_hash ={}
        
        for pos,num in enumerate(nums):
            rem = target - nums[pos]
            
            if rem in my_hash:
                return [pos,my_hash[rem]]
            
            else:
                my_hash[num] = pos