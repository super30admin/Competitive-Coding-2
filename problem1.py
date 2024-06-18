class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        hashMap = dict()
        for i in range(len(nums)):
            if target - nums[i] in hashMap.keys():
                return [i, hashMap[target - nums[i]]]
            else:
                hashMap[nums[i]] = i
        return []
# Time complexity O(n)
# Space complexity O(n)
# Problem 1: https://leetcode.com/problems/two-sum/description/