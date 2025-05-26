from typing import List

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        hashMap = {}
        for i in range(len(nums)):
            number = target - nums[i]
            if number in hashMap:
                return [i, hashMap.get(number)]
            hashMap[nums[i]] = i
        