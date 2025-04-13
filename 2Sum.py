# TC: O(n) We iterate through the list once, and dictionary lookups are O(1) on average
# SC: O(n) We store at most n elements in the hash_map
# Use a hash map to store numbers and their indices
# For each number, compute the remainder (target - nums[i])
# If the remainder is found in the hash map, return the two indices
# Otherwise, store the current number and its index in the hash map
from typing import List


class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:

        n = len(nums)
        hash_map = {}

        for i in range(n):
            rem = target - nums[i]  # Compute remainder
            if rem in hash_map:  # Check if remainder exists in hash_map
                return [hash_map[rem], i]  # Return indices of the two numbers
            hash_map[nums[i]] = i  # Store the current number with its index

        return (
            []
        )  # In case no solution is found (though the problem guarantees a solution)


sol = Solution()
sol.twoSum([2, 7, 11, 15], 9)  # Output: [0, 1]
