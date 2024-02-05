# Time complexity: O(n) n is the number of elements in num
# Space complexity: O(n) n is the space occupied by elements

class Solution:
    def twoSum(self, nums: list[int], target: int) -> list[int]:
        hashMap = {}
        for i in range(len(nums)):
            diff = target - nums[i]
            if nums[i] in hashMap:
                return [i, hashMap[nums[i]]]
            else:
                hashMap[diff] = i
