# Approach:
# Use a hash map to store each number's index as we iterate through the list.
# For each number, check if the complement (target - current number) is already in the map; if it is, return the indices.
# This ensures that we find the two indices in a single pass with constant-time lookups.

# Time Complexity: O(n), where n is the number of elements in nums.
# Space Complexity: O(n), due to the hash map storing up to n elements.
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        # Dictionary to store number and its index
        num_to_index = {}
        
        # Loop through each number in the list
        for i, num in enumerate(nums):
            # Calculate the complement of the current number
            complement = target - num
            
            # Check if the complement exists in the hash map
            if complement in num_to_index:
                # If found, return the indices of complement and current number
                return [num_to_index[complement], i]
            
            # If not found, store the number and its index in the map
            num_to_index[num] = i
