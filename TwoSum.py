# Time Complexity: O(n)
# Space Complexity: O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Approach:
# 1. We will use hash map to solve this problem.
# 2. We will iterate through the list and calculate the difference between target and current element.
# 3. If the difference is already present in the hash map, we will return the current index and the index of the difference.
# 4. If the difference is not present in the hash map, we will store the current element in the hash map.

from typing import List
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        # Initialize dictionary
        hashMap = {}
        # Iterate through the list
        for i in range(len(nums)):
            # calculate the difference
            diff = target - nums[i]
            # check if the difference is present in the hashMap, return the index and value of the difference (which is the index of the element)
            if diff in hashMap:
                return [i, hashMap[diff]]
            
            # store the value in hash map
            hashMap[nums[i]] = i