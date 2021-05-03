"""
Intuition:  Brute Force - Get all possible pair of elements and check if its sum == target.

Optimized Intuiion: Use a hashmap.
Use the formula : x + y = target.
If we know x and target, y can be calculated.
If y is in the hashmap, we have found the pair of numbers 

#####################################################################
#Brute Force
Time Complexity : O(n) where n = number of elements
Space Complexity : O(n)where n = number of elements

#Hashing
Time Complexity : O(n) where n = number of elements
Space Complexity : O(n)where n = number of elements
#####################################################################

"""

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        
        if len(nums) == 0:
            return [-1, -1]
        
        hashMap = {}
        
        for index in range(len(nums)):
            num = nums[index]
            
            if (target - num) not in hashMap:
                hashMap[num] = index
            else:
                return [hashMap[(target-num)], index]
        
        