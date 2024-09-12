class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        d = {}
        for key,value in enumerate(nums):
            diff = target - value
            if diff in d:
                return [key,d[diff]]
            d[value] = key