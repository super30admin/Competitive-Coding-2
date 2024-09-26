class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        dic = {}
        for i, j in enumerate(nums):
            remainder = target - j #remainder from current number to sum
            if remainder in dic:
                return [i, dic[remainder]]
            else:
                dic[j] = i