# The code defines a twoSum method to find two indices in the list nums such that the numbers at these indices add up to a specified target.
# The approach uses a hash map (dictionary) to efficiently track previously seen numbers and their indices.

# Initialization:
#   - 'prevMap' is an empty dictionary where each key-value pair will represent a number and its index in nums.

# Main Loop:
#   - Iterate over each element 'n' in nums along with its index 'i':
#       - Calculate 'diff' as the difference between the target and the current number (target - n).
#       - Check if 'diff' exists in 'prevMap':
#           - If it does, then 'n' and 'diff' add up to the target, and we have found the two numbers.
#           - Return the indices of 'diff' (from prevMap) and 'n' (i).
#       - If 'diff' is not in prevMap, add 'n' and its index 'i' to prevMap, allowing us to check for it in future iterations.

# Final Result:
#   - If a solution exists, the function will return the indices of the two numbers that add up to the target.
#   - If no solution is found by the end of the loop, the function will implicitly return None (not shown in this code, as a solution is assumed to exist).

# TC: O(n) - Each element in nums is processed once, resulting in linear time complexity.
# SC: O(n) - The space complexity is linear due to the hash map storing each number and its index.


from typing import List


class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        prevMap = {}  # val -> index

        for i, n in enumerate(nums):
            diff = target - n
            if diff in prevMap:
                return [prevMap[diff], i]
            prevMap[n] = i