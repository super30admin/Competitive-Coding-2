# Time Complexity : O(n), where n is the number of elements in the array
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def twoSum(self, nums, target):

        map_indices = dict()

        for i, num in enumerate(nums):
            if num in map_indices:
                return [map_indices[num], i]

            map_indices[target - num] = i

        return [-1, -1]


s = Solution()
arr = [2, 7, 11, 15]
target = 9
print(s.twoSum(arr, target))
