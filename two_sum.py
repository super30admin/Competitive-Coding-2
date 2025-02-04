# Time: O(n)
# Space: O(n)
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        dictNums = {}
        for i, num in enumerate(nums):
            dictNums[num] = i
        for i, num in enumerate(nums):
            remaining = target - num
            if remaining in dictNums and dictNums[remaining] != i:
                return [i, dictNums[remaining]]
        return [-1, -1]