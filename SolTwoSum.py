class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        complement = dict()
        for i in range(0, len(nums)):
            if nums[i] in complement:
                return [i, complement[nums[i]]]
            else:
                complement[target - nums[i]] = i