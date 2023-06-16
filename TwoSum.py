# Time Complexity : O(n)
# Space Complexity : O(n)

# The code ran on LeetCode

# Store indices on elemensts in a hash map. Calculate residual at every index and check if the residual is already present in the hash map.

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        
        d = {}

        for i in range(len(nums)):
            residual = target - nums[i]
            if residual in d:
                return [i, d[residual]]
            else:
                d[nums[i]] = i

        return [-1, -1]s