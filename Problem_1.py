from typing import List

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        map = {}
        for i in range(len(nums)):
            if (target - nums[i]) in map.keys():
                return [i, map[target - nums[i]]]
            else:
                map[nums[i]] = i
        return [-1, -1]

obj = Solution()
print(obj.twoSum([2,7,11,15],9))
print(obj.twoSum([3,2,4],6))
print(obj.twoSum([3,3],6))

# Time Complexity: O(n)
# Space Complexity: O(n)