# Time Complexity : O(n), where n is the number of elements in the list
# Space Complexity : O(n), for the hashmap used to store elements
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : No

from typing import List

class Solution:

    def twoSum(self, nums: List[int], target: int) -> List[int]:

        # -----------------------------------------
        # Optimized approach using hashmap
        # Time Complexity: O(n)
        # Space Complexity: O(n)
        # -----------------------------------------
        
        numMap = {}

        for i in range(len(nums)):
            complement = target - nums[i]
            if complement in numMap:
                return [numMap[complement], i]
            else:
                numMap[nums[i]] = i

        return []

        # -----------------------------------------
        # Brute-force approach
        # Time Complexity: O(n^2)
        # Space Complexity: O(1)
        # -----------------------------------------
        # for i in range(len(nums)):
        #     for j in range(i + 1, len(nums)):
        #         if nums[i] + nums[j] == target:
        #             return [i, j]

        # return []


if __name__ == "__main__":
    sol = Solution()

    print(sol.twoSum([2, 7, 11, 15], 9))       # Expected: [0, 1]
    print(sol.twoSum([3, 2, 4], 6))            # Expected: [1, 2]
    print(sol.twoSum([3, 3], 6))               # Expected: [0, 1]
    print(sol.twoSum([1, 2, 3, 4, 5], 9))      # Expected: [3, 4]
    print(sol.twoSum([0, 4, 3, 0], 0))         # Expected: [0, 3]
