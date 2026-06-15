#https://leetcode.com/problems/two-sum/description/
# Time Complexity  : O(n),single loop through the array
# Space Complexity : O(n),HashMap stores up to n elements
# LeetCode Status  : Accepted
# Problems Faced   : None

class Solution:
    def twoSum(self, nums, target):
       
        map = {}                                # Create an empty HashMap to store {number: index}

        
        for i in range(len(nums)):              # Loop through each number one by one
            
            complement = target - nums[i]       # Calculate what number we need to complete the pair  

            if complement in map:               # Check if that number already exists in our map
                return [map[complement], i]     # If found, return the stored index of complement and the current index i

            map[nums[i]] = i                    # If not found, store current number and its index